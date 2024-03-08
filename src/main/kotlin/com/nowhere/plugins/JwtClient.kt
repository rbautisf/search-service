package com.nowhere.plugins

import com.auth0.jwk.JwkProviderBuilder
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.jwt.JWTPrincipal
import io.ktor.server.auth.jwt.jwt


import java.net.URL
import java.util.concurrent.TimeUnit

fun Application.configureJwtClient() {
    val issuer = environment.config.property("ktor.jwt.issuer").getString()
    val providedUrl = environment.config.property("ktor.jwt.jwkProviderUrl").getString()
    val myRealm = environment.config.property("ktor.jwt.realm").getString()
    val jwkProvider = JwkProviderBuilder(URL(providedUrl))
        .cached(10, 24, TimeUnit.HOURS)
        .rateLimited(10, 1, TimeUnit.MINUTES)
        .build()

    install(Authentication) {
        jwt("auth-jwt") {
            realm = myRealm
            verifier(jwkProvider, issuer) {
                acceptLeeway(3)
            }
            validate { credential ->
                if (credential.payload.getClaim("subject").asString() != "") {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
        }
    }
}
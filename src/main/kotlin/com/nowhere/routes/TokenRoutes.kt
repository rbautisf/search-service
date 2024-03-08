package com.nowhere.routes

import com.nowhere.models.Token
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.tokenRoute() {
    authenticate("auth-jwt") {
        get("/token") {
            // Get the principal from the security context and return its name
            // concat all the data from the token
            val principal = call.principal<JWTPrincipal>()
            // map the claims into the Token data class
            val token = Token(
                principal?.payload?.subject ?: "No subject found in token",
                principal?.payload?.issuer ?: "No issuer found in token",
                principal?.payload?.getClaim("aud")?.asString() ?: "No audience found in token",
                principal?.payload?.expiresAt?.time ?: 0,
                principal?.payload?.issuedAt?.time ?: 0,
                principal?.payload?.getClaim("jti")?.asString() ?: "No jti found in token",
                principal?.payload?.getClaim("name")?.asString() ?: "No name found in token",
                principal?.payload?.getClaim("email")?.asString() ?: "No email found in token",
                principal?.payload?.getClaim("roles")?.asString() ?: "No roles found in token"
            )

            call.respond(token)
        }
    }
}
package com.nowhere.plugins

import com.nowhere.routes.searchRoutes
import com.nowhere.routes.tokenRoute
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
            tokenRoute()
            searchRoutes()
    }
}
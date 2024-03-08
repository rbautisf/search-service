package com.nowhere.routes

import com.nowhere.models.postStorage
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get


fun Route.searchRoutes() {
    get("/search") {
        val query = call.request.queryParameters["query"] ?: return@get call.respondText(
            "Bad Request",
            status = HttpStatusCode.BadRequest
        )
        val posts = postStorage.filter {
            it.title.contains(query, ignoreCase = true) || it.content.contains(query, ignoreCase = true)
        }
        call.respond(posts)
    }
}
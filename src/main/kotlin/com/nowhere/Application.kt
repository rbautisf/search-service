package com.nowhere

import com.nowhere.plugins.configureJwtClient
import com.nowhere.plugins.configureRouting
import com.nowhere.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureJwtClient()
    configureRouting()
    configureSerialization()
}
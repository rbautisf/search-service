package com.nowhere.models

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val sub: String,
    val iss: String,
    val aud: String,
    val exp: Long,
    val iat: Long,
    val jti: String,
    val name: String,
    val email: String,
    val roles: String
)

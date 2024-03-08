package com.nowhere.models

import kotlinx.serialization.Serializable

@Serializable
data class Posts(val id: Int, val title: String, val content: String, val author: String, val date: String)

val postStorage = listOf(
    Posts(1, "First Post", "This is the first post.", "John Doe", "2020-01-01"),
    Posts(2, "Second Post", "This is the second post.", "John Doe", "2020-01-02"),
    Posts(3, "Another Post", "This is a post.", "Jane Smith", "2020-01-03")
)
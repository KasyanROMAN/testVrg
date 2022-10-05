package com.example.testtaskvrg.View.model

data class DisplayablePost (
    val id: String,
    val author: String,
    val title: String,
    val subredditName: String,
    val contentHtml: String?,
    val commentsCount: Int,
    val score: Int,
    val created: String,
    val thumbnail: String?,
    val url: String
)
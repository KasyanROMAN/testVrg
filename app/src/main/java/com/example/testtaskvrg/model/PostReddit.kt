package com.example.testtaskvrg.model

data class PostReddit(
    val id: String,
    val author: String,
    val title: String,
    val subreddit_name_prefixed: String,
    val selftext_html: String?,
    val num_comments: Int,
    val score: Int,
    val created: Long,
    val thumbnail: String?,
    val url: String,
    val visited: Boolean
)
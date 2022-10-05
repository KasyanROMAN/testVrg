package com.example.testtaskvrg.model

data class Listing(val data: ListingData) {

    data class ListingData(
        val modhash: String?,
        val children: List<PostItem>,
        val after: String?,
        val before: String?
    )

    data class PostItem (val data: PostReddit)
}
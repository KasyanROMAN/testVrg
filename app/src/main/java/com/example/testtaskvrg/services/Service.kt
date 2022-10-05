package com.example.testtaskvrg.services

import com.example.testtaskvrg.model.Listing
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("{subreddit}/top.json")
    fun getNewItems(@Path("subreddit") subreddit: String = "") : Maybe<Listing>
}

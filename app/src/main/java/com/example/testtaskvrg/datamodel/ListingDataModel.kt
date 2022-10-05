package com.example.testtaskvrg.datamodel

import com.example.testtaskvrg.model.PostReddit
import io.reactivex.Observable

interface ListingDataModel {

    fun postsNew(): Observable<List<PostReddit>>
}
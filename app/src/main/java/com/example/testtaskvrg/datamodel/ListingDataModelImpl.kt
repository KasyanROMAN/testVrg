package com.example.testtaskvrg.datamodel

import com.example.testtaskvrg.model.Listing
import com.example.testtaskvrg.model.PostReddit
import com.example.testtaskvrg.services.Service
import io.reactivex.Observable
import javax.inject.Inject


class ListingDataModelImpl @Inject constructor(private val service: Service) : ListingDataModel {

    override fun postsNew(): Observable<List<PostReddit>> {
        return service.getNewItems()
            .map { (data) -> data.children.map(Listing.PostItem::data) }
            .toObservable()
    }
}
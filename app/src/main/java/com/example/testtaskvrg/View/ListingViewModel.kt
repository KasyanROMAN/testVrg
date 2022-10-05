package com.example.testtaskvrg.View

import com.example.testtaskvrg.View.model.DisplayablePost
import com.example.testtaskvrg.datamodel.ListingDataModel
import com.example.testtaskvrg.model.PostReddit
import io.reactivex.Observable
import javax.inject.Inject
import io.reactivex.functions.Function


class ListingViewModel
@Inject constructor(private val dataModel: ListingDataModel,
                    private val displayablePostRedditMapper: Function<PostReddit, DisplayablePost>) : IListingViewModel {

    override fun postsNew(): Observable<List<DisplayablePost>> {
        return dataModel.postsNew()
            .map { posts -> posts.map(displayablePostRedditMapper::apply) }
    }
}
package com.example.testtaskvrg.View

import com.example.testtaskvrg.View.model.DisplayablePost
import io.reactivex.Observable

interface IListingViewModel{

    fun postsNew() : Observable<List<DisplayablePost>>
}
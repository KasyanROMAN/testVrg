package com.example.testtaskvrg.di

import com.example.testtaskvrg.View.IListingViewModel
import com.example.testtaskvrg.View.ListingViewModel
import com.example.testtaskvrg.View.mapper.DisplayablePostMapper
import com.example.testtaskvrg.View.mapper.HtmlStringMapper
import com.example.testtaskvrg.View.model.DisplayablePost
import com.example.testtaskvrg.datamodel.ListingDataModel
import com.example.testtaskvrg.datamodel.ListingDataModelImpl
import com.example.testtaskvrg.model.PostReddit
import com.example.testtaskvrg.services.Service
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import io.reactivex.functions.Function
@Module
class MainModule {

    @Provides
    fun provideViewModel(
        dataModel: ListingDataModel,
        displayablePostRedditMapper: Function<PostReddit, DisplayablePost>
    ): IListingViewModel {
        return ListingViewModel(dataModel, displayablePostRedditMapper)
    }

    @Provides
    fun provideDisplayablePostMapper(
        dateMapper: Function<Long, String>,
        htmlMapper: Function<String?, String?>
    ): Function<PostReddit, DisplayablePost> {
        return DisplayablePostMapper(dateMapper)
    }

    @Provides
    fun provideHtmlStringMapper(): Function<String?, String?> {
        return HtmlStringMapper()
    }


    @Provides
    fun provideDataModel(service: Service): ListingDataModel {
        return ListingDataModelImpl(service)
    }

    @Provides
    fun provideService(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }
}
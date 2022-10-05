package com.example.testtaskvrg.di.component

import com.example.testtaskvrg.MainActivity
import com.example.testtaskvrg.di.MainModule
import com.example.testtaskvrg.di.RetrofitModule
import dagger.Component
import javax.inject.Singleton
import dagger.android.AndroidInjector


@Singleton
@Component(modules = arrayOf(MainModule::class, RetrofitModule::class))
interface MainComponent : AndroidInjector<MainActivity>
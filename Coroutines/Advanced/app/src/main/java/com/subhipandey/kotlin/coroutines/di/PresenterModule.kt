
package com.subhipandey.kotlin.coroutines.di

import com.subhipandey.kotlin.coroutines.ui.movies.MoviesPresenter
import com.subhipandey.kotlin.coroutines.ui.movies.MoviesPresenterImpl
import org.koin.dsl.module



fun presenterModule() = module {
  single { MoviesPresenterImpl(get()) as MoviesPresenter }
}
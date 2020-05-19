
package com.subhipandey.kotlin.coroutines.di

import com.subhipandey.kotlin.coroutines.data.database.MovieDatabase
import com.subhipandey.kotlin.coroutines.domain.repository.MovieRepository
import com.subhipandey.kotlin.coroutines.domain.repository.MovieRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

fun appModule() = module {

  single { MovieDatabase.create(androidContext()) } // database

  single { get<MovieDatabase>().movieDao() } // dao

  single { MovieRepositoryImpl(get(), get()) as MovieRepository } // repository
}
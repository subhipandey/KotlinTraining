package com.subhipandey.markme.di

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.subhipandey.markme.feature.FeatureContract
import com.subhipandey.markme.feature.presenter.FeaturePresenter
import com.subhipandey.markme.main.MainContract
import com.subhipandey.markme.main.presenter.MainPresenter
import com.subhipandey.markme.model.Student
import com.subhipandey.markme.model.database.AppDatabase
import com.subhipandey.markme.repository.AppRepository
import com.subhipandey.markme.splash.SplashContract
import com.subhipandey.markme.splash.presenter.SplashPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val applicationModule = module(override = true) {
    factory<SplashContract.Presenter> { (view: SplashContract.View) -> SplashPresenter(view) }
    factory<MainContract.Presenter> { (view: MainContract.View) -> MainPresenter(view) }
    factory<FeatureContract.Presenter<Student>> { (view: FeatureContract.View<Student>) -> FeaturePresenter(view) }
    single<FeatureContract.Model<Student>> { AppRepository }
    single<SharedPreferences> { androidContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE) }
    single {
        Room.databaseBuilder(androidContext(),
                AppDatabase::class.java, "app-database").build()
    }
}
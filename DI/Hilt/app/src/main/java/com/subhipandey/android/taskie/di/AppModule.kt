package com.subhipandey.android.taskie.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

const val KEY_PREFERENCES = "taskie_preferences"

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context):SharedPreferences {
        return context.getSharedPreferences(KEY_PREFERENCES, Context.MODE_PRIVATE)
    }
}
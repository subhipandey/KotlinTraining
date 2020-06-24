package com.subhipandey.android.taskie.di

import com.subhipandey.android.taskie.preferences.PreferencesHelper
import com.subhipandey.android.taskie.preferences.PreferencesHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class PersistenceModule {

    @Binds
    @Singleton
    abstract fun bindPreferencesHelper(
        preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper
    }

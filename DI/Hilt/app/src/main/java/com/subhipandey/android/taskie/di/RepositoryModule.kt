package com.subhipandey.android.taskie.di

import com.subhipandey.android.taskie.networking.RemoteApi
import com.subhipandey.android.taskie.networking.RemoteApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteApi(remoteApi: RemoteApiImpl):RemoteApi
}
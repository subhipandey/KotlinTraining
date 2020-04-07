

package com.subhipandey.android.photosapp.app

import android.content.Context
import com.subhipandey.android.photosapp.repository.PhotosRepository
import com.subhipandey.android.photosapp.repository.Repository
import com.subhipandey.android.photosapp.ui.photos.PhotosViewModelFactory


object Injection {

  fun provideRepository(context: Context?): Repository {
    return PhotosRepository()
  }

  fun provideViewModelFactory(context: Context?): PhotosViewModelFactory {
    val repository = provideRepository(context)
    return PhotosViewModelFactory(repository)
  }
}
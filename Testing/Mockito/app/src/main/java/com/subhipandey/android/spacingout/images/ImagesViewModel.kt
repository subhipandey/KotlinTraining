

package com.subhipandey.android.spacingout.images

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.subhipandey.android.spacingout.SpacingAnalytics
import com.subhipandey.android.spacingout.models.ApodImage
import kotlinx.coroutines.launch

class ImagesViewModel(
    private val imageListProvider: ImageListProvider,
    private val analytics: SpacingAnalytics)
  : ViewModel() {

  val imageLiveData = MutableLiveData<List<ApodImage>>()
  val errorLiveData = MutableLiveData<String>()

  init {
    viewModelScope.launch {
      try {
        analytics.logEvent("Fetching images")
        val items = imageListProvider.buildImageList().filter { it.media_type == "image" }
        imageLiveData.value = items
      } catch (exception: Exception) {
        errorLiveData.value = exception.message
      }
    }
  }
}
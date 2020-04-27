

package com.subhipandey.android.spacingout.lookup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.subhipandey.android.spacingout.logEvent
import com.subhipandey.android.spacingout.network.SpacingOutApi
import kotlinx.coroutines.launch

class LookupViewModel : ViewModel() {

  val imageLiveData = MutableLiveData<String>()
  val showErrorLiveData = MutableLiveData<String>()

  private val api = SpacingOutApi.create()

  fun latLongInput(latitude: Float, longitude: Float) = viewModelScope.launch {
    try {
      val image = api.getEarthImagery(longitude, latitude)
      imageLiveData.value = image.url
      logEvent("image retrieved", mapOf("latitude" to latitude.toString(), "longitude" to longitude.toString()))
    } catch (e: Exception) {
      showErrorLiveData.value = e.message
    }
  }
}
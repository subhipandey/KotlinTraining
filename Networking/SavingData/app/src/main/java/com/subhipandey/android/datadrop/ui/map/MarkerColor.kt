

package com.subhipandey.android.datadrop.ui.map

import com.google.android.gms.maps.model.BitmapDescriptorFactory


enum class MarkerColor(val displayString: String) {
  RED("Red"), GREEN("Green"), BLUE("Blue");

  fun getMarkerBitmapDescriptor() =
      when (this) {
        MarkerColor.GREEN -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
        MarkerColor.BLUE -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        else -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
      }

  companion object {
    fun createMarkerColor(displayString: String) =
        when (displayString) {
          "Green" -> GREEN
          "Blue" -> BLUE
          else -> RED
        }
  }
}
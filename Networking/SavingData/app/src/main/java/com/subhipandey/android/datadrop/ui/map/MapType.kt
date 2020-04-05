

package com.subhipandey.android.datadrop.ui.map

import com.google.android.gms.maps.GoogleMap


enum class MapType(val displayString: String) {
  NORMAL("Normal"), SATELLITE("Satellite"), HYBRID("Hybrid");

  fun getGoogleMapType() =
      when (this) {
        MapType.SATELLITE -> GoogleMap.MAP_TYPE_SATELLITE
        MapType.HYBRID -> GoogleMap.MAP_TYPE_HYBRID
        else -> GoogleMap.MAP_TYPE_NORMAL
      }

  companion object {
    fun createMapType(displayString: String) =
        when (displayString) {
          "Satellite" -> SATELLITE
          "Hybrid" -> HYBRID
          else -> NORMAL
        }
  }
}
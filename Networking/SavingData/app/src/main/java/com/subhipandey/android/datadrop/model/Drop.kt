

package com.subhipandey.android.datadrop.model

import com.google.android.gms.maps.model.LatLng
import java.util.*


data class Drop(val latLng: LatLng, val dropMessage: String, val id: String = UUID.randomUUID().toString(),
                val markerColor: Int = 0) {
  val latLngString = "%.6f, %.6f".format(latLng.latitude, latLng.longitude)
}
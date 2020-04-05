

package com.subhipandey.android.datadrop.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

@Entity(tableName = "marker_color_table")
data class MarkerColor(@PrimaryKey val displayString: String){
    companion object {
        const val RED_COLOR ="Red"
        const val GREEN_COLOR = "Green"
        const val BLUE_COLOR = "Blue"

        fun getMarkerBitmapDescriptor(color: String): BitmapDescriptor  =
                when (color) {
                    GREEN_COLOR -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                    BLUE_COLOR -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
                    else -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                }
    }
}


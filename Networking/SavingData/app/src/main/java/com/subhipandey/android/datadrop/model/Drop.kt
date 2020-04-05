

package com.subhipandey.android.datadrop.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import java.util.*

@Entity(tableName = "drop_table",
        foreignKeys = [(ForeignKey(entity = MarkerColor::class,
                parentColumns = ["displayString"],
                childColumns = ["markerColor"],
                onDelete = ForeignKey.CASCADE))])
data class Drop(val latLng: LatLng, val dropMessage: String, @PrimaryKey val id: String = UUID.randomUUID().toString(),
                val markerColor: String = MarkerColor.RED_COLOR) {
  fun latLngString() = "%.6f, %.6f".format(latLng.latitude, latLng.longitude)
}

package com.subhipandey.android.datadrop.model

import com.google.android.gms.maps.model.LatLng
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException


class DropTypeAdapter : TypeAdapter<Drop>() {

  @Throws(IOException::class)
  override fun read(reader: JsonReader): Drop {
    var latitude = 0.0
    var longitude = 0.0
    var dropMessage = ""
    var id = ""

    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.nextName()) {
        "latitude" -> latitude = reader.nextDouble()
        "longitude" -> longitude = reader.nextDouble()
        "dropMessage" -> dropMessage = reader.nextString()
        "id" -> id = reader.nextString()
      }
    }
    reader.endObject()

    return Drop(LatLng(latitude, longitude), dropMessage, id)
  }

  @Throws(IOException::class)
  override fun write(out: JsonWriter, drop: Drop) {
    out.beginObject()
    out.name("latitude").value(drop.latLng.latitude)
    out.name("longitude").value(drop.latLng.longitude)
    out.name("dropMessage").value(drop.dropMessage)
    out.name("id").value(drop.id)
    out.endObject()
  }
}
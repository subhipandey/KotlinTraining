package com.subhipandey.android.datadrop.model

import android.util.JsonWriter
import android.view.WindowManager
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import java.io.IOException

class DropTypeAdapter : TypeAdapter<Drop>() {

    override fun read(reader: JsonReader): Drop? {
        return null
    }

    @Throws(IOException::class)
    override fun write(out: com.google.gson.stream.JsonWriter, drop: Drop) {
        out.beginObject()
        out.name("latitude").value(drop.latLng.latitude)
        out.name("longitude").value(drop.latLng.longitude)
        out.name("dropMessage").value(drop.dropMessage)
        out.name("id").value(drop.id)
        out.endObject()
    }
}
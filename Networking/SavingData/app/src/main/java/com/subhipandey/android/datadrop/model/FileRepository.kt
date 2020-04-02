package com.subhipandey.android.datadrop.model

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.subhipandey.android.datadrop.app.DataDropApplication
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.StringBuilder

object FileRepository : DropRepository {

    private val gson: Gson
    get(){
        val builder = GsonBuilder()
        builder.registerTypeAdapter(Drop::class.java, DropTypeAdapter())
        return builder.create()
    }
    override fun addDrop(drop: Drop) {
       val string = gson.toJson(drop)
        try{
            val dropStream = dropOutputStream(drop)
            dropStream.write(string.toByteArray())
            dropStream.close()
        } catch (e: IOException) {
            Log.e("FileRepository", "Error Saving Drop")
        }
    }

    private fun getContext() = DataDropApplication.getAppContext()

    override fun getDrops(): List<Drop> {
        return emptyList()
    }

    override fun clearDrop(drop: Drop) {
        TODO("Not yet implemented")
    }

    override fun clearAllDrops() {
        TODO("Not yet implemented")
    }

    private fun dropDirectory() = getContext().getDir("drops", Context.MODE_PRIVATE)
    private fun dropFile(filename: String) = File(dropDirectory(), filename)

    private fun dropFileName(drop: Drop) = drop.id + ".drop"
    private fun dropOutputStream(drop: Drop): FileOutputStream {
        return FileOutputStream(dropFile(dropFileName(drop)))
    }

}
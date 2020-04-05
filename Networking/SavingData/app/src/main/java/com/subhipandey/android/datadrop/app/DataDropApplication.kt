

package com.subhipandey.android.datadrop.app

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.google.android.gms.maps.model.LatLng
import com.subhipandey.android.datadrop.model.*


class DataDropApplication : Application() {

  companion object {
    lateinit var database: DropDatabase

    private lateinit var instance: DataDropApplication

    fun getAppContext(): Context = instance.applicationContext
  }

  override fun onCreate() {
    instance = this
    super.onCreate()

    database = Room.databaseBuilder(this, DropDatabase::class.java, "drop_database")
            .addCallback(roomDatabaseCallback).build()
  }

  private val roomDatabaseCallback = object : RoomDatabase.Callback() {
    override fun onOpen(db: SupportSQLiteDatabase) {
      super.onOpen(db)
      PopulateDbAsync(DataDropApplication.database).execute()
    }
  }

  private class PopulateDbAsync(db: DropDatabase) : AsyncTask<Void, Void, Void>() {
    private val markerColorDao: MarkerColorDao = db.markerColorDao()
    private val dropDao: DropDao = db.dropDao()

    override fun doInBackground(vararg params: Void): Void? {
      var markerColor = MarkerColor(MarkerColor.RED_COLOR)
      markerColorDao.insert(markerColor)
      markerColor = MarkerColor(MarkerColor.GREEN_COLOR)
      markerColorDao.insert(markerColor)
      markerColor = MarkerColor(MarkerColor.BLUE_COLOR)
      markerColorDao.insert(markerColor)

      val drop = Drop(LatLng(37.4220, -122.0841), "42")
      dropDao.insert(drop)

      return null
    }
  }

}
package com.subhipandey.android.datadrop.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface MarkerColorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(markerColor: MarkerColor)

    @Query("DELETE FROM marker_color_table ORDER BY displayString ASC")
    fun deleteAll()

    @Query("SELECT * FROM marker_color_table")
    fun getAllMarkerColors(): LiveData<List<MarkerColor>>

}
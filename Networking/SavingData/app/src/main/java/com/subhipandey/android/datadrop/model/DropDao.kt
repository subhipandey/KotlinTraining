package com.subhipandey.android.datadrop.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import androidx.lifecycle.LiveData

@Dao
interface DropDao {

    @Insert
    fun insert(drop: Drop)

    @Delete
    fun clearDrops(vararg drop: Drop)

    @Query("SELECT * FROM drop_table ORDER BY dropMessage ASC")
    fun getAllDrops(): LiveData<List<Drop>>
}
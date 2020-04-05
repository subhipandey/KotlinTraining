package com.subhipandey.android.datadrop.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.subhipandey.android.datadrop.app.DataDropApplication


class MarkerColorViewModel(application: Application) : AndroidViewModel(application) {
    private val markerColorDao = DataDropApplication.database.markerColorDao()
    private val allMarkerColors = markerColorDao.getAllMarkerColors()

    fun getMarkerColors() = allMarkerColors
}
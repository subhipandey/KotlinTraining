

package com.subhipandey.android.datadrop.ui.map

import com.subhipandey.android.datadrop.model.Drop
import com.subhipandey.android.datadrop.model.DropRepository
import com.subhipandey.android.datadrop.model.MapPrefs


class MapPresenter(private val repo: DropRepository, private val view: MapContract.View) : MapContract.Presenter {

  override fun start() {
    view.showDrops(getDrops())
  }

  override fun getDrops(): List<Drop> {
    return repo.getDrops()
  }

  override fun addDrop(drop: Drop) {
    repo.addDrop(drop)
    view.showDrop(drop)
  }

  override fun clearAllDrops() {
    repo.clearAllDrops()
  }

  override fun saveMarkerColor(markerColor: String) {
MapPrefs.saveMarkerColor(markerColor)
  }

  override fun getMarkerColor(): String = MapPrefs.getMarkerColor()
  override fun saveMapType(mapType: String) {
    MapPrefs.saveMapType(mapType)
  }

  override fun getMapType(): String = MapPrefs.getMapType()
}

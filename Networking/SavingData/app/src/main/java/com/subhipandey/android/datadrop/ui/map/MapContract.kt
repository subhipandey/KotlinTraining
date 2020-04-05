

package com.subhipandey.android.datadrop.ui.map

import com.subhipandey.android.datadrop.model.Drop
import com.subhipandey.android.datadrop.ui.base.BasePresenter
import com.subhipandey.android.datadrop.ui.base.BaseView


interface MapContract {
  interface View : BaseView<Presenter> {
    fun showDrop(drop: Drop)
    fun showDrops(drops: List<Drop>)
  }

  interface Presenter : BasePresenter {
    fun getDrops(): List<Drop>
    fun addDrop(drop: Drop)
    fun clearAllDrops()
    fun saveMarkerColor(markerColor: String)
    fun getMarkerColor(): String
    fun saveMapType(mapType: String)
    fun getMapType(): String
  }
}
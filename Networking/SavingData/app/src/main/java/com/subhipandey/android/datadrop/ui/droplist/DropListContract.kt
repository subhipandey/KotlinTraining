

package com.subhipandey.android.datadrop.ui.droplist

import com.subhipandey.android.datadrop.model.Drop
import com.subhipandey.android.datadrop.ui.base.BasePresenter
import com.subhipandey.android.datadrop.ui.base.BaseView


interface DropListContract {
  interface View : BaseView<Presenter> {
    fun showDrops(drops: List<Drop>)
    fun removeDropAtPosition(position: Int)
  }

  interface Presenter : BasePresenter {
    fun getDrops(): List<Drop>
    fun deleteDropAtPosition(drop: Drop, position: Int)
  }
}
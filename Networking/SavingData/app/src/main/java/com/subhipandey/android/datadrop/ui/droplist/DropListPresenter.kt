

package com.subhipandey.android.datadrop.ui.droplist

import com.subhipandey.android.datadrop.model.Drop
import com.subhipandey.android.datadrop.model.DropRepository


class DropListPresenter(private val repo: DropRepository, private val view: DropListContract.View) : DropListContract.Presenter {
  override fun start() {
    view.showDrops(getDrops())
  }

  override fun getDrops(): List<Drop> {
    return repo.getDrops()
  }

  override fun deleteDropAtPosition(drop: Drop, position: Int) {
    repo.clearDrop(drop)
    view.removeDropAtPosition(position)
  }
}

package com.subhipandey.android.datadrop.app

import com.subhipandey.android.datadrop.model.DropRepository
import com.subhipandey.android.datadrop.model.FileRepository
import com.subhipandey.android.datadrop.model.SQLiteRepository
import com.subhipandey.android.datadrop.ui.droplist.DropListContract
import com.subhipandey.android.datadrop.ui.droplist.DropListPresenter
import com.subhipandey.android.datadrop.ui.map.MapContract
import com.subhipandey.android.datadrop.ui.map.MapPresenter

object Injection {

  private fun provideDropRepository(): DropRepository = SQLiteRepository()

  fun provideMapPresenter(view: MapContract.View): MapContract.Presenter {
    return MapPresenter(provideDropRepository(), view)
  }

  fun provideDropListPresenter(view: DropListContract.View): DropListContract.Presenter {
    return DropListPresenter(provideDropRepository(), view)
  }
}
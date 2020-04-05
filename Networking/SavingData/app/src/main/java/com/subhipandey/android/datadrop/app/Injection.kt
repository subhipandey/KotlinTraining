
package com.subhipandey.android.datadrop.app

import com.subhipandey.android.datadrop.model.DropRepository
import com.subhipandey.android.datadrop.model.RoomRepository


object Injection {

  fun provideDropRepository(): DropRepository = RoomRepository()

}
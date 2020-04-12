

package com.subhipandey.android.w00tze.app

import com.subhipandey.android.w00tze.repository.BasicRepository
import com.subhipandey.android.w00tze.repository.Repository
import com.subhipandey.android.w00tze.repository.StubRepository


object Injection {
  fun provideRepository(): Repository = BasicRepository
}
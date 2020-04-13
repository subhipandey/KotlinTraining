

package com.subhipandey.android.w00tze.repository

import androidx.lifecycle.LiveData
import com.subhipandey.android.w00tze.model.Either
import com.subhipandey.android.w00tze.model.Gist
import com.subhipandey.android.w00tze.model.Repo
import com.subhipandey.android.w00tze.model.User

interface Repository {
  fun getRepos(): LiveData<Either<List<Repo>>>
  fun getGists(): LiveData<Either<List<Gist>>>
  fun getUser(): LiveData<Either<User>>
}


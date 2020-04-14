

package com.subhipandey.android.w00tze.repository

import androidx.lifecycle.LiveData
import com.subhipandey.android.w00tze.model.*

interface Repository {
  fun getRepos(): LiveData<Either<List<Repo>>>
  fun getGists(): LiveData<Either<List<Gist>>>
  fun getUser(): LiveData<Either<User>>
  fun postGist(request: GistRequest): LiveData<Either<Gist>>
  fun deleteGist(gistId: String): LiveData<Either<EmptyResponse>>
  fun updateUser(request: UserRequest): LiveData<Either<User>>
}


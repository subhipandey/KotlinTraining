

package com.subhipandey.android.w00tze.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.subhipandey.android.w00tze.model.Gist
import com.subhipandey.android.w00tze.model.Repo
import com.subhipandey.android.w00tze.model.User


object StubRepository : Repository {

  override fun getRepos(): LiveData<List<Repo>> {
    val liveData = MutableLiveData<List<Repo>>()
    val repos = mutableListOf<Repo>()

    for (i in 0 until 100) {
      val repo = Repo("repo name")
      repos.add(repo)
    }

    liveData.value = repos

    return liveData
  }

  override fun getGists(): LiveData<List<Gist>> {
    val liveData = MutableLiveData<List<Gist>>()
    val gists = mutableListOf<Gist>()

    for (i in 0 until 100) {
      val gist = Gist("2018-02-23T17:42:52Z", "w00t")
      gists.add(gist)
    }

    liveData.value = gists

    return liveData
  }

  override fun getUser(): LiveData<User> {
    val liveData = MutableLiveData<User>()

    val user = User(
        1234L,
        "w00tze",
        "w00tze",
        "W00tzeWootze",
        "https://avatars0.githubusercontent.com/u/36771440?v=4")

    liveData.value = user

    return liveData
  }
}
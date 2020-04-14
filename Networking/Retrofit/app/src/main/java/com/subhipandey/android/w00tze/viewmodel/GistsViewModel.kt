

package com.subhipandey.android.w00tze.viewmodel

import android.accounts.AuthenticatorDescription
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.subhipandey.android.w00tze.app.Injection
import com.subhipandey.android.w00tze.model.Either
import com.subhipandey.android.w00tze.model.Gist
import com.subhipandey.android.w00tze.model.GistFile
import com.subhipandey.android.w00tze.model.GistRequest


class GistsViewModel(application: Application) : AndroidViewModel(application) {
  private val repository = Injection.provideRepository()
  private val allGists = repository.getGists()

  fun getGists() = allGists

  fun sendGist(description: String, filename: String, content: String): LiveData<Either<Gist>> {
    val gistFile = GistFile(content)
    val gistFiles = mapOf(filename to gistFile)
    val request = GistRequest(description, gistFiles)

    return repository.postGist(request)
  }

  fun deleteGist(gist:Gist) = repository.deleteGist(gist.id)
}
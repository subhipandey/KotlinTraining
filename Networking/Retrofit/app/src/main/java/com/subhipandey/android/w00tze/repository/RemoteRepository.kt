package com.subhipandey.android.w00tze.repository

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.subhipandey.android.w00tze.app.Injection
import com.subhipandey.android.w00tze.app.isNullOrBlankOrNullString
import com.subhipandey.android.w00tze.model.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

object RemoteRepository : Repository {

    private const val LOGIN = "w00tze"

    private val api = Injection.provideGithubApi()

    override fun getRepos(): LiveData<List<Repo>> {
        val liveData = MutableLiveData<List<Repo>>()

        api.getRepos(LOGIN).enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
                if (response != null) {
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
            }
        })

        return liveData
    }

    override fun getGists(): LiveData<List<Gist>> {
        val liveData = MutableLiveData<List<Gist>>()

        api.getGists(LOGIN).enqueue(object : Callback<List<Gist>> {
            override fun onResponse(call: Call<List<Gist>>?, response: Response<List<Gist>>?) {
                if (response != null) {
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Gist>>?, t: Throwable?) {
            }
        })

        return liveData
    }

    override fun getUser(): LiveData<Either<User>> {
        val liveData = MutableLiveData<Either<User>>()

        api.getUser(LOGIN).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if (response != null && response.isSuccessful) {
                    liveData.value = Either.success(response.body())
                } else {
                    liveData.value = Either.error(ApiError.USER, null)
                }
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                liveData.value = Either.error(ApiError.USER, null)
            }
        })

        return liveData
    }
}

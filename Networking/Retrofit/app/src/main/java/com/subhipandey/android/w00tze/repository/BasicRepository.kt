package com.subhipandey.android.w00tze.repository

import android.net.Uri
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.subhipandey.android.w00tze.app.Constants.fullUrlString
import com.subhipandey.android.w00tze.app.isNullOrBlankOrNullString
import com.subhipandey.android.w00tze.model.Gist
import com.subhipandey.android.w00tze.model.Repo
import com.subhipandey.android.w00tze.model.User
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

object BasicRepository : Repository {

    private const val TAG = "BasicRepository"

    private const val LOGIN = "w00tze"

    override fun getRepos(): LiveData<List<Repo>> {
        val liveData = MutableLiveData<List<Repo>>()

        FetchAsyncTask("/users/$LOGIN/repos", ::parseRepos, { repos ->
            liveData.value = repos
        }).execute()

        return liveData
    }

    override fun getGists(): LiveData<List<Gist>> {
        val liveData = MutableLiveData<List<Gist>>()

        FetchAsyncTask("/users/$LOGIN/gists", ::parseGists, { gists ->
            liveData.value = gists
        }).execute()

        return liveData
    }

    override fun getUser(): LiveData<User> {
        val liveData = MutableLiveData<User>()

        FetchAsyncTask("/users/$LOGIN", ::parseUser, { user ->
            liveData.value = user
        }).execute()

        return liveData
    }

    private fun <T> fetch(path: String, parser: (String) -> T): T? {
        try {
            val url = Uri.parse(fullUrlString(path)).toString()
            val jsonString = getUrlAsString(url)

            return parser(jsonString)
        } catch (e: IOException) {
            Log.e(TAG, "Error retrieving path: $path ::: ${e.localizedMessage}")
        } catch (e: JSONException) {
            Log.e(TAG, "Error retrieving path: $path ::: ${e.localizedMessage}")
        }
        return null
    }

    private fun parseRepos(jsonString: String): List<Repo> {
        val repos = mutableListOf<Repo>()

        val reposArray = JSONArray(jsonString)
        for (i in 0 until reposArray.length()) {
            val repoObject = reposArray.getJSONObject(i)
            val repo = Repo(repoObject.getString("name"))
            repos.add(repo)
        }

        return repos
    }

    private fun parseGists(jsonString: String): List<Gist> {
        val gists = mutableListOf<Gist>()

        val gistsArray = JSONArray(jsonString)
        for (i in 0 until gistsArray.length()) {
            val gistObject = gistsArray.getJSONObject(i)
            val createdAt = gistObject.getString("created_at")
            val description = gistObject.getString("description")
            val gist = Gist(createdAt, description)
            gists.add(gist)
        }

        return gists
    }

    private fun parseUser(jsonString: String): User {
        val userObject = JSONObject(jsonString)

        val id = userObject.getLong("id")
        val name = if (userObject.getString("name").isNullOrBlankOrNullString()) "" else userObject.getString("name")
        val login = userObject.getString("login")
        val company = if (userObject.getString("company").isNullOrBlankOrNullString()) "" else userObject.getString("company")
        val avatarUrl = userObject.getString("avatar_url")

        return User(
                id,
                name,
                login,
                company,
                avatarUrl)
    }

    private class FetchAsyncTask<T>(val path: String, val parser: (String) -> T, val callback: (T) -> Unit) : AsyncTask<(T) -> Unit, Void, T>() {
        override fun doInBackground(vararg params: ((T) -> Unit)?): T? {
            return fetch(path, parser)
        }

        override fun onPostExecute(result: T) {
            super.onPostExecute(result)
            if (result != null) {
                callback(result)
            }
        }
    }
}
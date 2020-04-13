package com.subhipandey.android.w00tze.repository

import com.subhipandey.android.w00tze.model.Gist
import com.subhipandey.android.w00tze.model.Repo
import com.subhipandey.android.w00tze.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{user}/repos")
    fun getRepos(@Path("user")user: String): Call<List<Repo>>

    @GET ("users/{user}/gists")
    fun getGists(@Path("user") user: String): Call<List<Gist>>

    @GET ("users/{user}")
    fun getUser(@Path("user") user: String): Call<List<User>>


}
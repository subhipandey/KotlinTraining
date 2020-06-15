

package com.subhipandey.android.potterverse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PotterApi {

  @GET("v1/characters")
  fun getCharacters(@Query("key") key: String = API_KEY): Call<List<CharacterModel>>
}


val API_KEY = "VErA5pZyGBuQmuKCzoTWXTVYkKr.6hdCVu6V1ULXZW"
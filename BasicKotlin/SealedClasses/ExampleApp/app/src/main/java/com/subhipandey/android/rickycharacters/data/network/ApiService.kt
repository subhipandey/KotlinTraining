

package com.subhipandey.android.rickycharacters.data.network

import com.subhipandey.android.rickycharacters.data.models.CharactersResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
  @GET("/api/character/")
  suspend fun getCharacters(): Response<CharactersResponseModel>

}
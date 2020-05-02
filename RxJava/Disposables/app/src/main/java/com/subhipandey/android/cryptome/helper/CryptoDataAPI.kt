package com.subhipandey.android.cryptome.helper

import com.google.gson.internal.LinkedTreeMap
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val APIKEY = "5ff4403acf7cd59e0913064705239875c0ed81a9e42a227cf91426e4c98aa883" // TODO 1: Add Your Register API Key Here
const val BASEURL = "https://min-api.cryptocompare.com/"

interface CryptoDataAPI {
  @Headers("Authorization: $APIKEY")
  @GET("data/pricemulti?fsyms=BTC,ETH,LTC")

  fun getCryptoData(@Query("tsyms") currencies: String): Observable<LinkedTreeMap<Object, Object>>
}
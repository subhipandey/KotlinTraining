package com.subhipandey.android.cryptome

import android.app.Application
import com.subhipandey.android.cryptome.helper.BASEURL
import com.subhipandey.android.cryptome.helper.CryptoDataAPI
import com.subhipandey.android.cryptome.helper.CryptoDataRepository
import com.subhipandey.android.cryptome.viewmodels.CryptoDataViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

  companion object {
    private lateinit var retrofit: Retrofit
    private lateinit var cryptoDataApi: CryptoDataAPI
    private lateinit var cryptoDataRepository: CryptoDataRepository
    private lateinit var cryptoDataViewModel: CryptoDataViewModel

    fun injectCryptoDataViewModel() = cryptoDataViewModel
  }

  override fun onCreate() {
    super.onCreate()

    retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    cryptoDataApi = retrofit.create(
        CryptoDataAPI::class.java)

    cryptoDataRepository =
        CryptoDataRepository(cryptoDataApi)
    cryptoDataViewModel = CryptoDataViewModel(cryptoDataRepository)
  }
}
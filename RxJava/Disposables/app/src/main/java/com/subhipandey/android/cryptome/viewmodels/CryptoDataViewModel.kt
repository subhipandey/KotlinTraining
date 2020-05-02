package com.subhipandey.android.cryptome.viewmodels

import android.util.Log
import com.google.gson.internal.LinkedTreeMap
import com.subhipandey.android.cryptome.helper.*
import com.subhipandey.android.cryptome.models.CryptoData
import com.subhipandey.android.cryptome.models.Price
import io.reactivex.Observable

class CryptoDataViewModel(private val cryptoDataRepository: CryptoDataRepository) {

  fun getCryptoData(currencies: String): Observable<List<CryptoData>> {
    return cryptoDataRepository.getCryptoData(currencies)
      .map {
        handleResult(it)
      }
      .onErrorReturn {
        Log.d("getCryptoData", "An error occurred")
        arrayListOf<CryptoData>().toList()
      }
  }

  private fun handleResult(result: LinkedTreeMap<Any, Any>): List<CryptoData> {
    val cryptoData = ArrayList<CryptoData>()
    for (entry in result.entries) {
      val cryptoTitle = entry.key as String
      val priceMap = entry.value as LinkedTreeMap<String, Float>
      val prices = ArrayList<Price>()
      for (price in priceMap.entries) {
        val newPrice = Price(price.key, price.value)
        prices.add(newPrice)
      }

      val newCryptoData = CryptoData(cryptoTitle, prices.toList())
      cryptoData.add(newCryptoData)
    }

    return cryptoData
  }

}
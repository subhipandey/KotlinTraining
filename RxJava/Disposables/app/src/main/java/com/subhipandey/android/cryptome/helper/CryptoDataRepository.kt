package com.subhipandey.android.cryptome.helper

import android.util.Log
import com.google.gson.internal.LinkedTreeMap
import io.reactivex.Observable

class CryptoDataRepository(private val cryptoDataAPI: CryptoDataAPI) {
    fun getCryptoData(currencies: String): Observable<LinkedTreeMap<Object, Object>> {
        return cryptoDataAPI.getCryptoData(currencies)
            .doOnNext {
                Log.d("getCryptoData", "Dispatching ${it.size} crypto data from API...")
            }
    }
}

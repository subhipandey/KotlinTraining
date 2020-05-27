package com.subhipandey.fp

import java.net.HttpURLConnection
import java.net.URL
import kotlin.streams.asSequence
import java.io.IOException as IOException1

object FunctionalFetcher {

  fun fetch(url: URL): Result<FetcherException, String> {
    try {
      with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"
        val reader = inputStream.bufferedReader()
        val json = reader.lines().asSequence().fold(StringBuilder()) { builder, line ->
          builder.append(line)
        }.toString()

        return Success(json)
      }
    } catch (ioe: IOException) {
      
      return Error(FetcherException(ioe.localizedMessage))
    }
  }
}


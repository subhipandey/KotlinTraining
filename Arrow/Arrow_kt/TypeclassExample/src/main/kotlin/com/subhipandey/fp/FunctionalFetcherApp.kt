package com.subhipandey.fp

import java.net.URL

object FunctionalFetcherResult {

  fun fetch(url: URL): Result<FetcherException, String> {
    try {
      with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"
        val reader = inputStream.bufferedReader()
        val result = reader.lines()
          .asSequence().fold(StringBuilder()) { builder, line ->
            builder.append(line)
          }.toString()

        return Success(result)
      }
    } catch (ioe: IOException) {

      return Error(FetcherException(ioe.localizedMessage))
    }
  }
}

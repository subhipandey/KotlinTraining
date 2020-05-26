package com.subhipandey.fp

import java.net.HttpURLConnection
import java.net.URL
import kotlin.streams.asSequence
import java.io.IOException as IOException1

class FetcherException(override val message: String) :
  IOException1(message)

object FunctionalFetcher {
  fun fetch(url: URL): String {
    try {
      with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"
        val reader = inputStream.bufferedReader()
        return reader.lines().asSequence().fold(StringBuilder()) { builder, line ->
          builder.append(line)
        }.toString()
      }
    } catch (ioe: IOException1) {
      throw FetcherException(ioe.localizedMessage)
    }
  }
}

fun main() {
  val ok_url = URL("https://jsonplaceholder.typicode.com/todos")
  val error_url = URL("https://error_url.txt")
  println(FunctionalFetcher.fetch(ok_url))
}
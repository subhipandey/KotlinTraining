package com.subhipandey.fp

import java.sql.DriverManager.println


data class User(val id: Int, val name: String, val email: String)

val userBuilder = { id: Int -> { name: String -> { email: String -> User(id, name, email) } } }

fun main() {
  val idAp = justResult(1)
  val nameAp = justResult("Max")
  val missingNameAp = Error(SgValidationException(arrayOf("Missing name!"))) // HERE
  val emailAp = justResult("max@maxcarli.it")
  val userAp = justResult(userBuilder)
  // 1
  (userAp appl idAp appl nameAp appl emailAp).mapRight { println(it) }
  // 2
  (userAp appl idAp appl missingNameAp appl emailAp).mapLeft { println(it) }
}


package com.subhipandey.fp



data class User(val id: Int, val name: String, val email: String)

val userBuilder = { id: Int -> { name: String -> { email: String -> User(id, name, email) } } }

fun main() {
  val idAp = justResult(1)
  val nameAp = justResult("Max")
  val missingNameAp = Error(IllegalStateException("Missing name!"))
  val emailAp = justResult("max@maxcarli.it")
  val userAp = justResult(userBuilder)

  (userAp appl idAp appl nameAp appl emailAp).mapRight { println(it) }

  (userAp appl idAp appl missingNameAp appl emailAp).mapLeft { println(it) }
}

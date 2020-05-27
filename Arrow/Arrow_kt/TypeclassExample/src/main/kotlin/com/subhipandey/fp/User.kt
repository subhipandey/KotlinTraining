package com.subhipandey.fp



data class User(val id: Int, val name: String, val email: String)

val userBuilder = { id: Int -> { name: String -> { email: String -> User(id, name, email) } } }

fun main() {
  val idAp = justResult(1)

  val missingNameAp = Error(IllegalStateException("Missing Name!"))
  val emailAp = justResult("max@maxcarli.it")
  val userAp = justResult(userBuilder)

  emailAp.ap(missingNameAp.ap(idAp.ap(userAp))).mapLeft {
    println(it)
  }
}

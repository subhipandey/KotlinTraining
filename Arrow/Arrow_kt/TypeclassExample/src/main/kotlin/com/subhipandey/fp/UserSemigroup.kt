package com.subhipandey.fp

import java.sql.DriverManager.println

fun main() {
  val idAp = justResult(1)
  val userAp = justResult(userBuilder)
  val validatedUser = userAp appl idAp appl validateName("Max") appl validateEmail("maxcarli.it")
  validatedUser.bimap({
    println("Error: $it")
  }, {
    println("Validated user: $it")
  })
}

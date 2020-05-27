package com.subhipandey.fp


class ValidationException(msg: String) : Exception(msg)


fun validateName(name: String): Result<ValidationException, String> =
  if (name.length > 4) Success(name) else Error(ValidationException("Invalid Name"))


fun validateEmail(email: String): Result<ValidationException, String> =
  if (email.contains("@")) Success(email) else Error(ValidationException("Invalid email"))

fun main() {

  val idAp = justResult(1)
  val userAp = justResult(userBuilder)

  val validatedUser = userAp appl idAp appl validateName("Massimo") appl validateEmail("max@maxcarli.it")

  validatedUser.bimap({
    println("Error: $it")
  }, {
    println("Validated user: $it")
  })
}


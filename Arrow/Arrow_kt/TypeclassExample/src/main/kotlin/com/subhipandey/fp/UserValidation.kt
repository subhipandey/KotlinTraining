package com.subhipandey.fp


class ValidationException(msg: String) : Exception(msg)


fun validateName(name: String): Result<SgValidationException, String> =
  if (name.length > 4) Success(name)
  else Error(SgValidationException(arrayOf("Invalid Name")))

fun validateEmail(email: String): Result<SgValidationException, String> =
  if (email.contains("@")) Success(email)
  else Error(SgValidationException(arrayOf("Invalid email")))


fun main() {
  val idAp = justResult(1)

  val userAp = justResult(userBuilder)

  val validatedUser = userAp appl idAp appl validateName("Max") appl validateEmail("maxcarli.it")
  validatedUser.bimap({
    it.messages.forEach {
      println("Error: $it")
    }
  }, {
    println("Validated user: $it")
  })
}


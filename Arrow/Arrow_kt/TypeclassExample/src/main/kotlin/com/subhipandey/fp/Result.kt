package com.subhipandey.fp

sealed class Result<out E, out A>
class Success<out A>(val a: A) : Result<Nothing, A>()
class Error<out E>(val a : E) : Result<E , Nothing>()
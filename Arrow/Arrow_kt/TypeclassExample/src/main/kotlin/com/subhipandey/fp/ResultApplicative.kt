package com.subhipandey.fp

class ResultApplicative {
  fun <T> justResult(value: T) = Success(value)

  fun <E : Semigroup<E>, T, R> Result<E, T>.ap(fn: Result<E, (T) -> R>): Result<E, R> = when (fn) {
    is Success<(T) -> R> -> mapRight(fn.a)
    is Error<E> -> when (this) {
      is Success<T> -> Error(fn.e)

      is Error<E> -> Error(this.e + fn.e)
    }
  }


  infix fun <E : Semigroup<E>, A, B> Result<E, (A) -> B>.appl(a: Result<E, A>) = a.ap(this)


}
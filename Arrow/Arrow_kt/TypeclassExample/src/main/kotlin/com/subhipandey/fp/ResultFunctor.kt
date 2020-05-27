package com.subhipandey.fp

fun <E1, E2, T, R> Result<E1, T>.bimap(fe: (E1) -> E2, fs: (T) -> R): Result<E2, R> = when (this) {
  is Success<T> -> Success(fs(this.a))
  is Error<E1> -> Error(fe(this.e))
}


fun <E, T, R> Result<E, T>.mapRight(fn: (T) -> R): Result<E, R> = when (this) {
  is Success<T> -> Success(fn(this.a))
  is Error<E> -> this
}



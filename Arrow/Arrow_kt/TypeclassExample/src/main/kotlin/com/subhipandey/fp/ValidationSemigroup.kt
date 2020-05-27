package com.subhipandey.fp


interface Semigroup<T> {
  operator fun plus(rh: T): T
}


class SgValidationException(val messages: Array<String>) : Semigroup<SgValidationException> {

  override operator fun plus(rh: SgValidationException) =
    SgValidationException(this.messages + rh.messages)
}

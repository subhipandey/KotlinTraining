
 
package rp

sealed class Maybe<out T>
class Some<T>(val value: T) : Maybe<T>()
object None : Maybe<Nothing>()

/**
 * We make the Maybe a functor implementing the map function
 */
fun <T, S> Maybe<T>.map(fn: (T) -> S): Maybe<S> = when (this) {
  is Some<T> -> Some<S>(fn(this.value))
  else -> None
}
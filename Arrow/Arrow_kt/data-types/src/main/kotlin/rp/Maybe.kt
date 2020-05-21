
 
package rp

import arrow.higherkind

// First version of Maybe as Kind specialisation
//class Maybe<T> : Kind<Maybe<T>, T>

/*
class ForMaybe private constructor()
typealias MaybeOf<T> = Kind<ForMaybe, T>
sealed class Maybe<out T> : MaybeOf<T>

class Some<T>(val value: T) : Maybe<T>()
object None : Maybe<Nothing>()
*/

/**
 * This is the fix method which returns the Of type as data type
 */
//fun <T> MaybeOf<T>.fix() = this as Maybe<T>

@higherkind
sealed class Maybe<out A> : MaybeOf<A> {
  companion object
}

data class Some<T>(val value: T) : Maybe<T>()
object None : Maybe<Nothing>()


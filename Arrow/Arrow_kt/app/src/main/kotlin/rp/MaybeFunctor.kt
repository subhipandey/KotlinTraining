
 
package fp

import arrow.Kind
import arrow.extension
import arrow.typeclasses.Functor


@extension
interface MaybeFunctor : Functor<ForMaybe> {
  override fun <A, B> Kind<ForMaybe, A>.map(fn: (A) -> B): Kind<ForMaybe, B> {
    val maybe = this.fix()
    return when (maybe) {
      is Some<A> -> Some<B>(fn(maybe.value))
      else -> None
    }
  }

  companion object
}

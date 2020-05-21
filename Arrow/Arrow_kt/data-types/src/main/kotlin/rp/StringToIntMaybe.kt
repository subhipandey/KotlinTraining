
 
package rp

val stringToIntMaybe: (String) -> Maybe<Int> =
  { s ->
    try {
      Some(Integer.parseInt(s))
    } catch (e: NumberFormatException) {
      None
    }
  }



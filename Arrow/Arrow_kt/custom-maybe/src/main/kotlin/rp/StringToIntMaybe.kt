
 
package rp

/**
 * Version of the stringToInt function which returns a Maybe
 */
val stringToIntMaybe: (String) -> Maybe<Int> =
  { s ->
    try {
      Some(Integer.parseInt(s))
    } catch (e: NumberFormatException) {
      None
    }
  }



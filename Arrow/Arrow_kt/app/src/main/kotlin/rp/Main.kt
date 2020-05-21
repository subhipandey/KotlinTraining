

package fp

import fp.maybe.functor.map

fun main() {
  stringToIntMaybe("123")
    .map(intToRoman)
    .map { print(it) }
}
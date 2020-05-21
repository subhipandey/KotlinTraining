
 
package rp

fun main() {
  stringToIntMaybe("Hello")
    .map(intToRoman)
    .map { print(it) }
  stringToIntMaybe("123")
    .map(intToRoman)
    .map { print(it) }
}
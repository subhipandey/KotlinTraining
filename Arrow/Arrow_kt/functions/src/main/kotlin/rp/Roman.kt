
 
package rp

val NUMBER_MAP = listOf(
  1000 to "M",
  900 to "CM",
  500 to "D",
  400 to "CD",
  100 to "C",
  90 to "XC",
  50 to "L",
  40 to "XL",
  10 to "X",
  9 to "IX",
  5 to "V",
  4 to "IV",
  1 to "I"
).toMap()

fun Int?.toRoman(): String {
  if (this == null) {
    return ""
  }
  var remainder = this
  var output = ""
  for ((threshold, numeral) in NUMBER_MAP) {
    while (remainder / threshold > 0) {
      remainder -= threshold
      output += numeral
    }
  }
  return output
}

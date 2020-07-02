fun main() {
    /*
    * Challenge:
    *
    * Use a when expression to return which century an arbitrary year is from (as a String).
    * Cover at least the last three centuries, and return “This was looong ago!” for others.
    *
    * Then print out the returned value. Use Ranges for year comparison.
    * */

    val year = 1999

    val century = when (year){
        in 2000..2020 -> "21st Century"
        in 1900..1999 -> "20th Century"
        in 1800..1899 -> "19th Century"
        else -> "This was a long ago"
    }

    print(century)
}
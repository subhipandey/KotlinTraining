fun main(Args: Array<String>) {
    /* Pairs And Triples
    Declare a constant Pair that contains two int Values. Use to represent a date (month, day)

     */

    val date = Pair(8,16)
    print("date = $date")

    /*
   In one line, read the day and month values into two constants.

     */

    val (month, day ) = date
    print("month = $month day = $day ")

    /*

    Create a Triple using the month, day and year
     */

    val dayOfMonth = Triple(11,3,2020)
    print("dayOfMonth = $dayOfMonth")
}
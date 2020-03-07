@file:Suppress("UNREACHABLE_CODE")

fun main (args: Array<String>) {
    val temperature = 37.5
    val count : Int = 5
    var name = "Sam"

    name = "Fred"

    fun calculateTemperature(celsius: Double) {} Double {
        return 9 / 5 * celsius + 32

    }
    print("Temp = ${calculateTemperature(20.0)}")
    print("Temp = ${calculateTemperature(50.0)}")

    //value to integer
    val intValue = "32".toInt()
    print("inValue = $intValue")
    // value to string
    val intString = 32.toString()
    print("inString = $intString")

    //Example of when statement
    val fahrenheit = 32
    when (fahrenheit) {
        in 0..30 -> print("really cold")
        in 31..40 -> print("Getting colder")
        in 41..50 -> print("Kind Of Cold")
        in 51..60 -> print("Nippy")
        in 71..80 -> print("It's just right")


    }

    //Example of Null

    var nullableName : String? = null
    var length = nullableName?.length ?: -1
    print(length)
    nullableName = "Sam"
    length = nullableName?.length ?: -1
    print(length)

    //Example Of Comments

    // This is the basic of Kotlin

    /*
    i will learn Kotlin from my left
    KJS from my right
     */

    /* Statement 1
    /* Statement 2
     */
     *
     */
}
/**
 *
 * This is a documentation style comment.
 * you can reference things here, like the [main] function
 * you can also reference parameters, like the [arguments].
 *
 * @param arguments (this is the example of Param Annotations)
 * @author Subhi
 * */

// Every main function can receive String Arguments from the console
fun main(arguments : Array<String>) {
    var myAge: Int = 21
    val name: String = "Subhi"
    val lastName = "Pandey"
    val weight = 63.5

    println(name)

    println("I am $myAge years old")

    myAge += 1
    println("I am $myAge years old")

    println("$name $lastName is $myAge years old")

    // Assign values to Variable and Constant

    val fullName = "$lastName, $name"
    println(fullName)

    // Convert Age Value to String

    val ageAsString = myAge.toString()
    println(ageAsString)

    // Converting String to Int

    val ageFromString = "35".toInt()
    println(ageFromString)

    // Assign FullName to a Constant
    val nameLength = fullName.length
    println(nameLength)

    // This is a line comment

    /*
    * This is Multi line comment
    *
    *
     */


}

/*
### BASIC Functions

Write a function named `printFullName` that takes two strings called `firstName` and `lastName`.
The function should print out the full name defined as `firstName` + " " + `lastName`.
Use it to print out your own full name using the parameter names.
*/

fun main(args: Array<String>) {
    fun printFullName(firstName: String, lastName: String) {
        print(firstName + " " + lastName)
    }
    printFullName(firstName = "Subhi", lastName = "Pandey")

    /*
 Use the printFullName function without any parameter names.
 */

    printFullName("Subhi", "Pandey")

    /*
Write a function named `calculateFullName` that returns the full name as a string.
Use it to store your own full name in a constant and then print it.
*/

    fun calculateFullName(firstName: String, lastName: String): String {
        return firstName + "" + lastName
    }

    print(calculateFullName("Subhi", "Pandey"))

    /*
 Create `calculateFullNameWithLength` to return a pair containing both the full name and the
 length of the name. You can find a string’s length by using the following
 syntax: `string.length`. Use this funtion to determine the length
 of your own full name. Then print out the result of the function.
 */

    fun calculateFullNameWithLength(firstName: String, lastName: String): Pair<String, Int> {
        val fullName = firstName + "" + lastName
        return Pair(fullName, fullName.length)

    }

    print(calculateFullNameWithLength("Subhi", "Pandey"))
}
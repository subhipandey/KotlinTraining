fun main() {
    /*
    * Challenge 1:
    *
    * Create a function which takes in two parameters - a name and a last name. Because not everyone has a last name,
    * leave the lastName parameter to be an empty String if it is not passed in.
    *
    * Then return how long the person's full name is.
    */

    /*
    * Challenge 2:
    *
    * Overload the function from the first challenge, by adding a list of Strings parameter, for middle names,
    * in case someone has one or more middle names.
    *
    * Use the function to return the full name length, for a name with and without middle names.
    * Remember to use named arguments if needed.
    * */

    fun getFullNameLength(name:String, lastName:String="") = name.length + lastName.length
    fun getFullNameLength(name:String,middleNames:List<String>, lastName:String=""): Int {
        val nameLength = name.length + lastName.length

        var middleNamesLength = 0
        for(middleName in middleNames) {
            middleNamesLength += middleName.length
        }

        return middleNamesLength + nameLength
    }

    val myNameLength = getFullNameLength("Subhi", "Pandey")
    print(myNameLength)

    val length = getFullNameLength("Salvador",listOf("Domingo", "Felipe", "Jacino"),"Dali")
    print(length)
}

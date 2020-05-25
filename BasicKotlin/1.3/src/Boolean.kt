fun main() {
    val isProgrammingAwesome = true

    println("is Programming awesome? $isProgrammingAwesome")

    val myAge = 21
    val isLegalDrivingAge = myAge >= 18
    print(isLegalDrivingAge)

    // Here we are using the greater than or equals operator which check that the first value is greater than
    // or  atleast equal to the second value

    val ageRaj = 27
    val isRajOlder = ageRaj > myAge
    print(isRajOlder)

    // This are operator which determine if the vallue A is greater than value B

    // Lets check whether A is less than B we are checking if i was born before 21st Century

    val yearOfBirth = 1999
    val isBornInTwentiethCentury = yearOfBirth < 2000
    print(isBornInTwentiethCentury)

    // In this example we are checking whether two constants or variable are the same by value


    val strangerName = "Raj"
    val myName = "Subhi"

    val isSameName = strangerName == myName
    print(isSameName)

    // Let's take a example where we take different value
    val areNameDifferent = myName != strangerName
    print(areNameDifferent)

    // in this example we added a exclamation point to front of the equal symbol negating it's result

    print(!areNameDifferent)

    val firstObject = Any() // Any is a type which all other types in coding comes out
    val secondObject = Any()  // And it adds some base behaviour to each type

    print(firstObject === secondObject)
    print(firstObject !== secondObject) // just like negeted equality this is negeted reference

    // We Add the following check to see if my name is an Empty String

    val isNameEmpty = myName.isEmpty()
    print(isNameEmpty)
}
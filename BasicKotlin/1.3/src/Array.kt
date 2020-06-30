fun main(){
    //val country1="Russia"
    //val country2="USA"
    //val country3="Poland"

    val visitedCountries: Array<String> = arrayOf(
        "India","USA","Poland",
        "Romania","Spain","Portugal",
        "Serbia","Hungary","Austria"
    )

    print(visitedCountries)
    print(visitedCountries.size)

    print(visitedCountries[3])

    //print(visitedCountries[20])
    //print(visitedCountries[-1])

    visitedCountries + "belgium"
    print(visitedCountries.size)

    visitedCountries[1] ="The United States Of America"
    print(visitedCountries[1])

    val sizedArray:Array<String> = Array(18) {""}
    val emptyArray = emptyArray<String>()

    val arrayOfInts = intArrayOf(2,3,4,5,6,7)

    val intArray = IntArray(10)
    print(intArray)

    print(visitedCountries.lastIndex)
    print(visitedCountries.last())
    print(visitedCountries.first())

    val currentCountry = "Spain"
    print(visitedCountries.contains(currentCountry))



    val hasVisitedSpain:Boolean = currentCountry in visitedCountries
    val hasNotVisitedSpain:Boolean = currentCountry !in visitedCountries

    print(hasVisitedSpain)
    print(hasNotVisitedSpain)

}
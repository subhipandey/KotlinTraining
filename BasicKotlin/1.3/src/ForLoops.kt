fun main() {
    val visitedCountries = arrayOf(
            "China", "India", "Poland,",
            "Austria", "USA", "Serbia",
            "Hungary", "Germany", "France"
    )

    val rangeFromZeroToTen = 0..10
    print(rangeFromZeroToTen)

    val exclusiveRange = 0 until 10
    print(exclusiveRange)

    for(index in rangeFromZeroToTen step 2){
        print(index)
    }

    print("")

    for(index in 10 downTo 0){
        print(index)
    }

    print("")

    for (countryIndex in 0..visitedCountries.lastIndex) {
        print(visitedCountries[countryIndex])
    }

    print("")

    for (country in visitedCountries){
        print("$country")
    }
}
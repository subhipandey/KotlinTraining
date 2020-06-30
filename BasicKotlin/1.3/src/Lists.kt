fun main() {
    val countries: List<String> = listOf("Russia", "USA", "China")
    print(countries)

    val mutableList = countries.toMutableList()

    mutableList.add("Germany")
    mutableList.add(1, "Greece")

    print(mutableList)
    mutableList.addAll(3, listOf("Austria", "Poland", "Hungary"))
    print(mutableList)

    val hasBeenToJapan = "Japan" in mutableList
    print(hasBeenToJapan)

    mutableList.remove("Japan")
    mutableList.removeAt(0)
    mutableList.removeAll(listOf("Russia", "USA", "Japan"))

    print(mutableList)

    mutableList[2] = "India"
    val combinedList = countries + mutableList
    val emptyList = emptyList<String>()

    print(mutableList)
    print(combinedList)
    print(emptyList)

    mutableList.clear()
    print(mutableList)

}
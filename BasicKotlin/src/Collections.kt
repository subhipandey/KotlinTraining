fun main (args: Array<String>) {
    val values = listOf(24, 5, 10,4)
    print(values.filter {it > 5})

    val names = listOf("Subhi" , "Donn", "Phllip" ,"Garima")
    print(names.first{it.length > 5})

    val cities = listOf("Mumbai", "Chennai", "Delhi" , "Kolkata")
    print(cities.any {it == "Pune"})
    print(cities.all {it.length > 6})

}
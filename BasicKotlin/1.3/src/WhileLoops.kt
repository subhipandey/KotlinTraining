fun main() {
    val visitedCountries = arrayOf(
            "China", "India", "Poland,",
            "Austria", "USA", "Serbia",
            "Hungary","Germany","France"
    )

    //Example of while loop
    var i = 0
    while (i < visitedCountries.size){
        print("Country at index $i is ${visitedCountries[i]}")
        i+=1

    }

    //Do-while loops
    i=0
    do{
        print("Country at index $i is ${visitedCountries[i]}")
        i+=1
    }while (i< visitedCountries.size)
}
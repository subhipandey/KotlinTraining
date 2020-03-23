fun main (args: Array<String>) {
    val ints = listOf(2 , 3, 20, 50)
    print(ints.filter {it > 10})

    fun List<Int>.filter(operator: (Int) -> Boolean) {

    }

    val myStringList = listOf("Sam", "Suzzy", "Jesse", "Ray", "Kevin")
    val updatedList = myStringList.filter { it.length > 3 }.sortedBy { it }
    print(updatedList)

    view.onClickListner { print("In ClickListner")}


}
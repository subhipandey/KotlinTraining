fun main (args: Array<String>){
    /**
     * Create a function named printItem that prints out a generic parameter.
     * Call the parameter "item"
     */

    fun <T> printItem(item: T) {
        print("My item is $item")
    }

    printItem(1)
    printItem("Hello")

    /**
     * Create a function named printList that takes a generic list as a parameter
     * and prints out each item
     */

    fun<T> printList(List: List<T>) {
        for (item in List) {
            print("List item: $item")
        }
    }

    printList(listOf("Subhi", "Sagar" , "Donn Felkar"))
}
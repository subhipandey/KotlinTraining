fun main(args: Array<String>) {
    val names = Arraylist<String>()
    val myNumbers = ArrayList<Number>()
    myNumbers.add(1)
    myNumbers.add(2.5)
    print(myNumbers)

class person(val name: String) {}
class PersonRepository : Respository<Person> {
    override fun addItem(Item: Person) {
        TODO("Not yet implemented")
    }

    override fun deleteItem(item: Person) {
        TODO("Not yet implemented")
    }
}
    fun<T> printItem(item: T) {
        print(item)
    }
    fun<MyItem> printItem2(item: MyItem) {
        print(item)
    }
    printItem("test")
}

interface Respository<T> {
 fun addItem(Item:T)
    fun deleteItem(item: T)

}

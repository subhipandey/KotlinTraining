class Person(
    var firstName: String? = null,
    var lastName: String? = null) {

    var fullName: String
    get() {
        return firstName + " " + lastName
    }

    val otherName : String = ""
    private set


}

 var itemList: ArrayList<String> = ArrayList<String>()
set(value) {
    field = value
}

fun main(args: Array<String>) {

    val person = Person("Sam", "Smith")
    print("Person: ${person.firstName} ${person.lastName}")

}
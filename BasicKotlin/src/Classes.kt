class Person (
    val firstName : String,
         var lastName: String = "Gangee") {



}
fun main (args: Array<String>) {
val person = Person("Sam")
    val person2 = Person("Sam", "Gangee")

    print("person1 = ${person.firstName} ${person.lastName}")
    print("person2 = ${person2.firstName} ${person2.lastName}")



}
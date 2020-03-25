class Person {
    var firstName = ""
    var child = Child()
    fun firstName(firstName : String ) {
        this.firstName = firstName
    }

    inner class Child {
        var firstName = ""

        fun printParentage() {
            print("Child ${this@Child.firstName} with parent ${this@Person.firstName}")
        }

    }
}

fun String.lastChar() : Char.get(this.length -1)
fun main (args: Array<String>) {
    val person = Person()
    person.firstName = "Sam"
    person.Child.firstName = "Suzy"
    person.child.printPercentage()

    print("Hello there ${"Sammy".lastChar()}")
}
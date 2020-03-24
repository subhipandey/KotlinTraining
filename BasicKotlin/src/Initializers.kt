fun main(args: Array<String>) {
    class Person(var firstName: String, var lastName : String ) {
        var fullName : String
        init {
            fullName = firstName + " " + lastName
        }


    }

    val person = Person("Sam", "Gangee")
    print(person.fullName)

}
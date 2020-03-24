data class Student(val firstName : String, val lastName: String, val grade: Char)
data class Student2(val firstName : String, val lastName: String, val grade: Char = 'A')




fun main (args: Array<String>) {
    /**
     * Write a data class named Student with a firstName, lastName of type String
     * and a grade with a type Char
     */

    var sam = Student("Sam", "Gamgee", 'A')
    print(sam)

    sam = sam.copy(grade = 'B')
    print(sam)

    val fred = Student2("Fred", "Smith")
    print(fred)
}
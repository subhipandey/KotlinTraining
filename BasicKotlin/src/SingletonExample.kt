/**
 * Given the Student data class below, create a StudentRegistry
 * singleton that has a list of students and can add and remove a
 * student from that list.
 *
 */

data class Student(val firstName: String, val lastName: String)

object StudentRegistry {
    val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student) {
        allStudents.add(student)
    }

    fun removeStudent(student: Student) {
        allStudents.remove(student)
    }
}

fun main (args: Array<String>) {
    val steve = Student("Steve", "Miller")
    val john = Student("John", "Smith")
    StudentRegistry.addStudent(steve)
    StudentRegistry.addStudent(john)
    StudentRegistry.allStudents.forEach {
        println(it.firstName + " " + it.lastName)
    }
}
/**
* Create a class named Course that takes a className String parameter
* Add a private lateinit variable for the Teacher's name
* Then create a setTeacherName function that sets that variable
*/

class Course(var className: String) {
    lateinit var teacherName: String

    fun setTeacher(teacher: String) {
        teacherName = teacher
    }
}

fun main (args: Array<String>) {
   val course = Course("Kotlin")
    course.setTeacher("Donn Felker")

    print(course.teacherName)
}
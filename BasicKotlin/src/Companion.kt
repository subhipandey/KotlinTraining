class Student private constructor() {
    var firstName : String? = null
    var lastName : String? = null
    companion object Loader {
        fun loadStudent(jsonText: String) : Student {
            val student = Student()
            student.firstName = "FirstName"
            student.lastName = "LastName"
            return student

        }
    }
}
fun main(args: Array<String>) {
    val student = Student.loadStudent(jsonText: "JSON Text")
}
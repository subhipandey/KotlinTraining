package advanced
data class Grade3(val courseName: String, val letter: Char)

open class Person5(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student3(firstName: String, lastName: String,
                   var grades: MutableList<Grade> = mutableListOf<Grade>()
) : Person5(firstName, lastName) {

    open var isEligible: Boolean = true

    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class BandMember3(firstName: String, lastName: String): Student(firstName, lastName) {
    var minimumPracticeTime: Int = 2

    val isEligible
        get() = grades.none { it.letter == 'F' }

    override fun recordGrade(grade: NewGrade) {
        super.recordGrade(grade)
        if (!isEligible) println("No more performing for $firstName! Study study study.")
    }
}

class StudentAthlete3(firstName: String, lastName: String): Student(firstName, lastName) {
    override fun recordGrade(grade: NewGrade) {
        super.recordGrade(grade)
        val isEligible = grades.filter { it.letter == 'F' }.size < 3
        if (!isEligible) println("$firstName can't play in the big game! Time to study.")
    }
}


fun main() {
    val jon = Person(firstName = "Jon", lastName = "Snon")
    val jane = Student(firstName = "Jane", lastName = "Snane")
    val victor = BandMember("Victor", "Wooten")
    val marty = StudentAthlete("Marty", "McWolf")

    val persons = arrayOf(jon, jane, victor, marty)
    val students = arrayOf(jane, victor, marty)

    persons.forEach{ person ->
        print("${person.fullName()} is  a person!")
        if ([person is Student) println(persons.grades)
    }

    val student = victor as Student
    val bassist = student as? BandMember

    fun afterClassActivity(student: Student): String {
        return "Goes Home!"
    }

    fun afterClassActivity(student: BandMember): String {
        return "Practices for ${student.minimumPracticeTime} hours!"
    }

    println(afterClassActivity(victor as Student))
}

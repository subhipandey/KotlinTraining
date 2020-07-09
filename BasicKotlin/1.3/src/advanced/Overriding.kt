package advanced

data class Grade2(val courseName: String, val letter: Char)

open class Person4(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student2(firstName: String, lastName: String,
                    var grades: MutableList<Grade> = mutableListOf<Grade>()
) : Person4(firstName, lastName) {

    open var isEligible: Boolean = true

    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class BandMember2(firstName: String, lastName: String) : Student(firstName, lastName) {
    var minimumPracticeTime: Int = 2
    var isEligible: Boolean = true
        get() = grades.none { it.letter == 'F' }

    override fun recordGrade(grade: NewGrade) {
        super.recordGrade(grade)
        if (!isEligible) println("No more performing for $firstName! Study study study.")
    }
}

class StudentAthlete2(firstName: String, lastName: String) : Student(firstName, lastName) {
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

    val utterFailureGrade = Grade(courseName = "Being a Regular Human", letter = 'F')
    marty.recordGrade(utterFailureGrade)
    marty.recordGrade(utterFailureGrade)
    marty.recordGrade(utterFailureGrade)

    victor.recordGrade(utterFailureGrade)
}

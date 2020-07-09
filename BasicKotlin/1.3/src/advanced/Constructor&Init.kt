package advanced

data class NewGrade(val courseName: String, val letter: Char)

open class NewStudent(var firstName: String, var lastName: String,
                   var grades: MutableList<Grade> = mutableListOf<Grade>()) {
    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class NewBandMember(firstName: String, lastName: String): Student(firstName, lastName) {
    var minimumPracticeTime: Int = 2
    val isEligible
        get() = grades.none { it.letter == 'F' }

    constructor(firstName: String,lastName: String, minimumPracticeTime: Int): this(firstName, lastName){
        this.minimumPracticeTime = minimumPracticeTime
    }

    constructor(transfer: NewBandMember): this(transfer.firstName, transfer.lastName, transfer.minimumPracticeTime){
        grades = transfer.grades
        if (isEligible) minimumPracticeTime += 1
        println("transfer constructor practice time for $minimumPracticeTime hours")
    }

    init{
        if (isEligible) minimumPracticeTime += 1
        println("init practice time for $minimumPracticeTime hours")
    }
    init{
        if (isEligible) minimumPracticeTime += 1
        println("init practice time for $minimumPracticeTime hours")
    }
    init{
        if (isEligible) minimumPracticeTime += 1
        println("init2 practice time for $minimumPracticeTime hours")
    }

}


fun main() {

    val bill = NewBandMember(firstName = "Bill", lastName = "Preston")
    bill.recordGrade(NewGrade(courseName = "Motivation Speaking", letter = 'A'))
    bill.recordGrade(NewGrade(courseName = "Guitar", letter = 'B'))

    val transferredBill = NewBandMember(transfer = bill)
    print(transferredBill.grades)
    val ted = NewBandMember(firstName = "Ted", lastName = " Logan", minimumPracticeTime = 7 )
}
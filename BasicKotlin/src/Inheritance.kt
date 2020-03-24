import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinder

fun main(args: Array<String>) {
    class Grade(var letter: Char, var points: Double, var credits: Double)
   open class Person(var firstName: String, var lastName: String)
    open class Student(firstName: String,  lastName: String,
                    grades: ArrayList<Grade> = ArrayList()) : Person(firstName, lastName) {
      open  fun recordGrade(grade: Grade) {
            grades.add(grade)
        }
    }
    val john = Person("John","Annie")
    val jane = Student("Jane","Annie")

    print(john.firstName)
    print(jane.firstName)

    val history = Grade('B', points = 9.0, credits = 3.0)
    jane.recordGrade(history)

    open class BandMember(firstName: String, lastName: String) : Student(firstName, lastName) {
        open var minimumPracticeTime = 2
    }

    class OboePlayer(firstName: String, lastName: String) : BandMember(firstName, lastName) {
        override var minimumPracticeTime: Int
            get() {
                return super.minimumPracticeTime * 2
            }
        set(value){
            super.minimumPracticeTime = value / 2
        }
    }

    fun phonebookName(person: Person) : String {
        return "${person.lastName}, ${person.firstName}"

    }

    val person = Person(firstName = "Subhi", lastName = "Pandey")
    val oboePlayer = OboePlayer("Subhi", "Pandey")
    print(phonebookName(person))
    print(phonebookName(OboePlayer))

    var hallMonitor = Student("Jane", "Dawson")
    hallMonitor = oboePlayer

    (oboePlayer as BandMember).minimumPracticeTime = 4

    (hallMonitor as? BandMember)?.let {
        print("This hall monitor is a band member and practices at least ${hallMonitor.minimumPracticeTime} hours per week.")


    }
    fun afterClassActivity(student: Student) : String {
          return "HomeComing"
    }
    fun afterClassActivity(student: BandMember) : String {
          return "HomeComing"
    }

    print(afterClassActivity(oboePlayer))
    print(afterClassActivity(oboePlayer as Student))

    class StudentAthelete(firstName: String, lastName: String) : Student(firstName, lastName) {
        var failClasses = ArrayList<Grade>()

        override fun recordGrade(grade: Grade) {
            super.recordGrade(grade)

            if(grade.letter == 'F') {
                failClasses.add(grade)
            }
        }
        var isEligible : Boolean = true
        get() {
            return failedClasses.size < 3
        }
    }

}
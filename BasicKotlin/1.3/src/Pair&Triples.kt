fun main() {
    //Example of Triple
    val birthday: Triple<Int, Int, Int> = Triple(15, 0, 1999)
    //Example of pair
    val person: Pair<String, Triple<Int, Int, Int>> = Pair("Subhi Pandey", birthday)

    val nameUsingOrdering: String = person.first
    val birthdayUsingOrdering: Triple<Int, Int, Int> = person.second

    val (name: String, bday: Triple<Int, Int, Int>) = person
    val (day: Int, month: Int, _: Int) = bday

    //Example of Ordering Notation
    val yearOfBirth:Int = bday.third
    print("$name was born on $day/$month, year unknown!")
}
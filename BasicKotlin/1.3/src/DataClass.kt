data class Person3(
        val name: String,
        val lastName: String?,
        val age: Int,
        val pet: Pet2
)

data class Pet2(val name: String, val animalType: String)

fun main() {
    val dog = Pet2("Max", "Germand Shepard Dog")
    val subhi = Person3("Subhi", "Pandey", 21, dog)

    println(subhi)

    val olderFilip = subhi.copy(age = subhi.age + 20)
    println(olderFilip)

    val (name, _, age, pet2) = olderFilip
    println(pet2)

    val firstName = olderFilip.component1()
    println(firstName)

    var subhiTwo = subhi
    println(subhiTwo == subhi)
    println(subhiTwo === subhi)

    subhiTwo = subhi.copy()
    println(subhiTwo == subhi)
    println(subhiTwo === subhi)
}
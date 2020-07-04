import sun.security.krb5.internal.PAEncTSEnc

class Pet(var name: String, val animalType: String)


class Person2(
        private val name: String,
        private val lastName: String?,
        private var age: Int,
        val pet: Pet
) {
    fun setAge(age: Int) {
        if (age in 0..150) {
            this.age = age
        } else {

        }
    }

    fun getAge() = age
    fun getFullInformation(): String {
        return "Full Name: $lastName, $name, Age: $age, Pet: $pet, ${pet.animalType}"
    }
}


fun main() {
    var dog = Pet("Jura", "Goldie/Husky/Labrador Mix")
    val subhi = Person2("Subhi", "Pandey", 21, dog)
    print(subhi.getFullInformation())

    subhi.setAge(26)
    print(subhi.getAge())

    dog.name = "Scratchy"
    dog = Pet("Jura", "Goldie")
    print(subhi.pet.name)
}

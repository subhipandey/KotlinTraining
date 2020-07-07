package advanced

/*
Challenge 1:
Check out the Wizard class below and run the project.
Right now, `fullName` doesn't change when you update a wizard's first or last name.
Change the Wizard's fullName to a read-only computed property to fix that!

**Bonus Challenge**
Add a custom setter that will split a full name into a first and last name.
Only set firstName and lastName if the value contains exactly two names separated by a space
Hint: Use `.split(" ")` to split the value passed in into a list of strings
*/

/*
Challenge 2:
Add a "commonMagicalIngredients" list as a companion object property on Wizard.
Fill it with any magical ingredients you like!
*/

class Wizard(var firstName: String, var lastName: String) {
    var fullName: String
        get() = "$firstName $lastName"
        set(newFullName) {
            val names = newFullName.split("")
            if (names.size != 2) {
                print("$newFullName is not a proper full name for a wizard")
            } else {
                firstName = names.first()
                lastName = names.last()
            }
        }

    companion object {
        var commonMagicalIngredients = mutableListOf<String>(
                "Eye of heystack needle",
                "The Force",
                "Wow-Wow sauce"
        )
    }
}

fun main() {
    val wizard = Wizard("Hermione", "Sidious")
    println(wizard.fullName)

    wizard.lastName = "Skywalker"
    println(wizard.fullName)

    wizard.fullName = "SeverusWender"
    wizard.fullName = "Dracula the grey"
    print("First Name: ${wizard.firstName}, last name: ${wizard.lastName} ")

    wizard.fullName = "Lea Weatherwax"
    print("First Name: ${wizard.firstName}, last name: ${wizard.lastName} ")

    Wizard.commonMagicalIngredients.add("Meow Of cat")
    print(Wizard.commonMagicalIngredients)

}
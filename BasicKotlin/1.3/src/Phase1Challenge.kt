fun main() {
    /*
    * Challenge:
    * Create several values describing you as a person, in pieces of data. The pieces of data are as follows:
    * - Name
    * - Last name
    * - Nickname (if exists)
    * - Country
    * - Age
    *
    * Then find your year of birth using your age, and print out your data in the following format.
    *
    * Note: If you're underaged (< 18 years old), omit your `name`, and if you don't have a nickname, remove it from
    * the format.
    *
    * Format:
    * "$name '$nickname' $lastName, born on $yearOfBirth, in $country", if you have a nickname, otherwise, remove the
    * nickname from the format.
    * */

    val name = "Subhi"
    val lastName = "Pandey"
    val nickname: String? = null
    val country = "India"
    val age = 20

    val nameToPrint = if (age >= 18) "$name," else ""
    val nicknameToPrint = nickname ?: ""
    val yearOfBirth = 2020 - age
    val userData = "$nameToPrint $nicknameToPrint $lastName, born on $yearOfBirth, in $country"

    print(userData)
}

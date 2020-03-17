fun main (args: Array<String>) {
    /*
 ### Maps

 Create a Map with the following keys: name, profession, country, state, and city.
 For the values, put your own name, profession, country, state, and city.
 */

    val subhi = mutableMapOf(
        "name" to "Subhi",
        "profession" to "Android Developer", "country" to "India",
        "state" to "Maharashtra", "City" to "Mumbai"
    )
    print(subhi)

    /*
 You suddenly decide to move to Bangalore.
 Update your city to Bangalore, your state to Karnataka,
 and your country to USA.
 */

    subhi["city"] = "Bangalore"
    subhi["state"] = "Karnataka"

    print(subhi)

    /*
Given a Map in the above format, write a function that
prints a given player's city and state.
*/
    fun printLocation(person: Map<String, String>) {
        val state = if (person.containsKey("State")) person["State"] else ""
        val city = if (person.containsKey("City")) person["City"] else ""
        print("Person Lives in $city, $state")
        printLocation(subhi)

    }

}
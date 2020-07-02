fun main() {
    /*
    * Create a map where each key is the name of a pet you have/had, and the value is the animal type that pet is.
    *
    * E.g. Key: "Max", Value: "German Shepard Dog".
    *
    * Add the values to the map, then remove a value, and finally, iterate over the map, printing out the entries.
    * */

    val pets = mapOf("Teemo" to "Gray house cat",
            "cupka" to "black hamster",
            "Jura" to "Golden Retriever dog")

    for ((name, breed) in pets) {
        print("The pet $name is a $breed")
    }
}

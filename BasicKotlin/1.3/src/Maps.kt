fun main() {
    val videoGamesCollection = mutableMapOf<String, MutableList<String>>()
    print(videoGamesCollection)

    videoGamesCollection.put("Action", mutableListOf("Dark Souls", "Detroit Gone Human", "Injustice 2"))
    print(videoGamesCollection)

    val actionGames = videoGamesCollection["Action"]
    print(actionGames)

    val strategyGames = videoGamesCollection["Strategy"]
    print(strategyGames)

    val authenticationHeader = mapOf(
            "API_KEY" to "your-api-key",
            "Authorization" to "auth taken",
            "content/types" to "application/json"
    )

    print(authenticationHeader)

    // ---

    videoGamesCollection["Strategy"] = mutableListOf("Horoes of Might and Magic")
    print(videoGamesCollection)

    videoGamesCollection["Strategy"]?.add("Civilization 2")
    print(videoGamesCollection)

    val removedActionGames = videoGamesCollection.remove("Action")
    print(removedActionGames)
    print(videoGamesCollection)

    //authenticationHeader["Authorization"] = "new api key"
    videoGamesCollection["Strategy"]?.add("Command & Conquer")
    videoGamesCollection["Shooter"] = mutableListOf("DOOM")

    for (key in videoGamesCollection.keys) {
        print(key)
    }
    for (value in videoGamesCollection.values) {
        print(value)
    }

    for ((key, value) in videoGamesCollection) {
        print("video games in the $key genre you own are: $value")
    }
}
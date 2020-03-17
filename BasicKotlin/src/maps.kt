fun main (args: Array<String>) {
    var namesAndScores = mapOf("Anna" to 2, "Brain" to 2, "Craig" to 8, "Donna" to 6)
    print(namesAndScores)
    print(namesAndScores["Anna"])
    print(namesAndScores["Greg"])
    print(namesAndScores.isEmpty())
    print(namesAndScores.count())

    val bobData = mutableListOf("name" to "Bob", "profession" to "Card Player"
    ,"city" to "Mumbai", "Country" to "India")
    print(bobData)

    bobData["profession"] = "Mailman"
    print(bobData)
    bobData.remove("city")
    print(bobData)

    for ((player,score) in namesAndScores) {
        print("$player - $score")
    }
    for (player in namesAndScores.keys) {
        print("$player, ${namesAndScores[player]}")
    }
}

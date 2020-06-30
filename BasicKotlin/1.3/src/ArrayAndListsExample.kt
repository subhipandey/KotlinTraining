/*
  * Challenge:
  *
  * Create an Array of your five favorite games - be it board games, card games, or video games.
  * Change an element within the Array, and print out the second game.
  *
  * Transform the array to a list that can change its contents, and add two more games you'd like to play or finish.
  *
  * Then remove a game you've played most recently.
  *
  * Print out the list of games you ended up with!
  *
  * Finally, check if the removed game is still in the list!
  * */
fun main() {

    val games:Array<String> = arrayOf(
            "Last Of Us",
            "Skyrim",
            "Grand Theft Auto",
            "The Witcher" )

    games[2] = "The Tomb Raider"
    print(games[1])

    val gamesList = games.toMutableList()
    gamesList.addAll(listOf("Devil May Cry 5", "Spiderman PS4"))
    gamesList.remove("Grand Theft Auto")
    print(gamesList)

    print("Grand Theft Auto" in gamesList)
}
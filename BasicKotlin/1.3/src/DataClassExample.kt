fun main() {
    /*
    * Challenge:
    *
    * Following the first challenge in this course, change the classes from the first challenge to be `data` classes
    * instead, and remove unnecessary code, such as the formatting method, to rely on `toString()` instead.

    * Also make sure the class is immutable (use `val`s instead of `var`s, public modifiers for access).
    *
    * Create a copy of a certain object you created, and compare it for data equality and identity (reference equality).
    *
    * Destructure the object, and use the properties to print out its data.
    * */

    class VideoGames3(
      val genre: String,
      val name: String,
      val difficulty: String
    )

    val darkSouls = VideoGames3("Dark Fantasy RPG", "Dark Souls", "Hard")
    val divinityOriginalSin = VideoGames3("Turn based Game", "Divinity: Original Sin 2 ", "Medium")

    print(darkSouls)
    print(divinityOriginalSin)

    val darkSouls2 = darkSouls.copy(name = "Dark Souls 2")

    print(darkSouls == darkSouls2)
    print(darkSouls === darkSouls2)
    print(darkSouls2)

  val (genre,name,difficulty) = darkSouls
    print("$name is a famous $genre game , which is know for its $difficulty difficulty")

}

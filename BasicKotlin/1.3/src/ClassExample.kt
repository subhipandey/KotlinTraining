fun main() {
    /*
    * Challenge:
    *
    * Create a class which represents a Movie, a Video Game or a Song, whichever you prefer the most.
    * Add appropriate properties to the class, e.g. "name", "genre", "length" if it's a movie or a song.
    *
    * To those classes, add methods which format the properties in a String for you to print out.
    * Remember to add visibility modifiers where applicable, and get methods if needed.
    *
    * Create a few objects of the class type, and print out their formatted data.
    * */

    class VideoGame(
            private val genre:String,
            private val name:String,
            private var difficulty: String
    ){
        fun getData() = "$name is a $genre game, and it's difficulty is $difficulty"

        fun changedDifficulty(difficulty: String){
            this.difficulty = difficulty
        }
    }

    val darkSouls = VideoGame("Dark Fantasy RPG", "Dark Souls", "Hard")
    val divinityOriginalSins= VideoGame("Turn based Strategy RPG","Divinity","Medium" )
    print(darkSouls.getData())
    print(divinityOriginalSins.getData())

    darkSouls.changedDifficulty("Hard")
    print(darkSouls.getData())
}
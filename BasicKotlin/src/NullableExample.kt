fun main(args: Array<String>) {
    /*
 ### INTRODUCTION TO Nullables

 Make an Nullable `String` called `myFavoriteSong`. If you have a favorite song,
 set it to a string representing that song. If you have more than one favorite song
 or no favorite, set the Nullable to `null`.
 */

    var myFavouriteSong: String? = "The Final Countdown"

    /*
 Create a method named printFavoriteSong that takes a nullable song
 and print the value
 */
 fun printFavouriteSong(song: String?) {
        print(song)
    }

    printFavouriteSong(myFavouriteSong)
    myFavouriteSong = null
    printFavouriteSong(myFavouriteSong)
}
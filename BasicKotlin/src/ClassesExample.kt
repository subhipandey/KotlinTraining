fun main(args: Array<String>) {
    /*
 ## CLASSES VS STRUCTURES

 Imagine you're writing a movie-viewing application in Kotlin.
 Users can create lists of movies and share those lists with other users.

 Create a `MovieList`  and a `MovieGoer` class

 - `MovieList` - Contains a genre String passed in the constructor
    and an array of movie titles set as a property.
    Create a `print` method that will print all the movies in the list.
 - `MovieGoer` - Add a method `addList(movieList)` which adds the given list
    to a map of `movieList` objects (using the `genre` as a key).
    Add a method `movieListFor(genre) : MovieList?`
    that will return the Nullable `MovieList` for the provided genre.
    Add a method 'addMovie'(genre, movie) that will add a movie to the given genre
 - Create `jane` and `john` users in utils.main and have them create and share lists.
    Have both `jane` and `john` modify the same list and call `print` from both users.
    Are all the changes reflected?
*/

    class MovieList(val genre : String ) {
       private val movies = ArrayList<String>()
        fun addMovies(movie: String) {
            movies.add(movie)
        }
        fun print() {
            print("Movie List: $genre ")
            for (movie in movies ) {
                print(movie + "")
            }
            print()
        }
    }
    class MovieGoer {
      private  var movieList = HashMap<String, MovieList>
     //   fun addList(list:  MovieList) {
      //      movieList[list.genre] = list
      //  }

        fun addGenre(genre: String) {
            movieList[genre] = MovieList(genre)
        }

        fun movieListFor(genre: String) : MovieList {
            return movieList(genre)

        }

        fun addMovie(genre: String, movie: String) {
            if( !movieList.containKey(genre))
            movieList(genre)?.addMovie(Movie)
        }
    }
    fun main(args: Array<String>) {
        val jane = MovieGoer()
        val john = MovieGoer()
       //val actionList = MovieList("Action")

        //jane.addList(actionList)
        //john.addList(actionList)

        jane.addMovie("Action", "Baaghi")
        jane.addMovie("Action", "Singham")

        john.addMovie("Action", "Die Hard")

        jane.movieListFor("Action")?.print()
        john.movieListFor("Action")?.print()

    }

    /*
    ### Challenge 3

    Your challenge here is to build a set of objects to support a t-shirt store.

    - `TShirt` - Represents a shirt style you can buy. Each `TShirt` has a size (Int), color(Int), price (Double)
    - `Address` - Represents a shipping address, containing the
    number, street, city, and zip code.
    - `ShoppingCart` - Holds a current order, which is composed of an list of `TShirt`
    that the `User` wants to buy, as well as a method to calculate the total cost.
    Additionally, there is an `Address` that represents where the order will be shipped.

    - `User` - A registered user of the t-shirt store app.
    A user has a name, email, and a `ShoppingCart` (below).
    */


    class TShirt(var size : Int, var color : Int, var price : Double) {
    }
    class Address(var number: String, var street : String, var city : String, var zip : String) {
    }
    class ShoppingCart(var tshirts : List<TShirt>, var address: Address) {
        fun totalPrice() : Double {
            var total : Double = 0.0
            for (tshirt in tshirts) {
                total += tshirt.price
            }
            return total
        }
    }
    class User(var name : String, var email : String, var shoppingCart : ShoppingCart) {
    }

    val tshirt1 = TShirt(16, 1, 10.99)
    val tshirt2 = TShirt(18, 1, 12.99)
    val address = Address("10", "Seaside", "City of Lights", "99747")
    val cart = ShoppingCart(arrayListOf(tshirt1, tshirt2), address)
    val user = User("Sam", "someemail@aol.com", cart )
    println("Shoping Card total ${cart.totalPrice()}")

}
}

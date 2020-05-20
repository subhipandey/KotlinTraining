
data class Price(val value: Double, val currency: String = "$")


data class Book(
  val ISDN: String,
  val name: String,
  val pages: Int,
  val price: Price,
  val weight: Double,
  val year: Int,
  val author: String
)

val books = listOf<Book>(
  Book(
    "8850333404",
    "Android 6: guida per lo sviluppatore (Italian Edition)",
    846,
    Price(39.26, "£"),
    2.1,
    2016,
    "Massimo Carli"
  ),
  Book(
    "8850330731",
    "Android 3: Guida per lo sviluppatore (Italian Edition)",
    642,
    Price(40.06, "£"),
    1.8,
    2011,
    "Massimo Carli"
  ),
  Book(
    "885033334X",
    "Sviluppare applicazioni Android con Google Play services (Italian Edition)",
    325,
    Price(34.03, "£"),
    1.4,
    2015,
    "Massimo Carli"
  ),
  Book(
    "B00BVBVSZ8",
    "Creare la prima applicazione Android - Kindle",
    108,
    Price(3.99, "£"),
    0.0,
    2013,
    "Massimo Carli"
  ),
  Book(
    "885033222X",
    "Android 4: Guida per lo sviluppatore (Italian Edition)",
    725,
    Price(55.20, "£"),
    2.6,
    2013,
    "Massimo Carli"
  ),
  Book(
    "B00FED9XQ0",
    "RoboGuice e Robotium: Dependency Injection applicata ad Android - Kindle",
    121,
    Price(4.49, "£"),
    0.0,
    2013,
    "Massimo Carli"
  ),
  Book(
    "885033222X",
    "Android Activity: Gestire il flusso di navigazione di un'app  - Kindle",
    77,
    Price(4.49, "£"),
    0.0,
    2013,
    "Massimo Carli"
  ),
  Book(
    "8850330103",
    "Sviluppare applicazioni per Android (Italian Edition)",
    586,
    Price(30.54, "£"),
    1.8,
    2011,
    "Massimo Carli"
  )
)


fun main() {
  val androidBook = Book(
    "8850333404",
    "Android 6: guida per lo sviluppatore (Italian Edition)",
    846,
    Price(39.26, "£"),
    2.1,
    2016,
    "Massimo Carli"
  )
  val obj: Any = androidBook
  println("obj description: $obj")

  val myBook: Book = androidBook
  println("myBook description: $myBook")


}


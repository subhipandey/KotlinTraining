var anotherBook = Book(
    "8850330731",
    "Android 3: Guida per lo sviluppatore (Italian Edition)",
    642,
    Price(40.06, "£"),
    1.8,
    2011,
    "Massimo Carli"
)
var anotherBookFun = fun(book: Book) = book.weight
typealias BookMapper<T> = (Book) -> T

fun main() {

    // here we have Created a mapper variable, which references the function, which returns the weight of a book.

    var mapper: BookMapper<Double> = ::bookWeight

    var currency: BookMapper<String> = { book -> book.price.currency }

    println("Weight of ${books[0].name} is ${mapper(books[0])} Kg")

    mapper = ::bookPrice

    println("Price of ${books[0].name} is ${mapper(books[0])}${currency(books[0])}")
}

fun List<Book>.total(fn: BookMapper<Double>): Double =
    fold(0.0) { total, book -> total + fn(book) }

fun main() {

    val totalPrice = books.total { it.price.value }
    val totalWeight = books.total { it.weight }

    println("Total Price: ${totalPrice} £")
    println("Total Weight: ${totalWeight} Kg")

    // Use a predefined higher order function of Kotlin in order to print all the names of the list of books.
    books.forEach { println(it.name) }
}

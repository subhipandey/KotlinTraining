fun bookWeight(book: Book) = book.weight
fun bookPrice(book: Book) = book.price.value
val bookWeightFun = fun(book: Book) = book.weight
val bookPriceFun = fun(book: Book) = book.price.value

fun main() {

    var bookFun = bookWeightFun
    println("Book weight: ${bookFun(books[0])} Kg")


    bookFun = bookPriceFun
    println("Book price: ${bookFun(books[0])} £")
}

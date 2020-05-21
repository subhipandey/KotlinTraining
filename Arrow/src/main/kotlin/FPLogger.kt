typealias Writer<T, R> = (T) -> Pair<R, String>

val fpGetPrice: Writer<Book, Price> =
    fun(book: Book) = getPrice(book) to "Price calculated for ${book.ISDN}"

val fpFormatPrice: Writer<Price, String> =
    fun(price: Price) = formatPrice(price) to "Bill line created for $(format(price)}"

infix fun <A, B , C> Writer<A , B>.compose(f: Writer<B , C>): Writer<A , C> =
    {x: A ->
        val p1 = this(x)
        val p2 = f(p1.first)
        p2.first to p1.second + "\n" + p2.second
    }

fun main() {
    val getPriceWithLog = fpGetPrice compose fpFormatPrice
    books.forEach { book ->
        print(getPriceWithLog(book).second)
    }

}


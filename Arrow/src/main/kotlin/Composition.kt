import arrow.core.compose


typealias Func<A, B> = (A) -> B
val getPrice: Func<Book, Price> = { book -> book.price }

val formatPrice: Func<Price, String> =
    fun(priceData: Price) = "value: ${priceData.value}${priceData.currency}"

infix fun <A, B, C> Func<B, C>.after(f: Func<A, B>): Func<A, C> = { x: A -> this(f(x)) }

fun main() {

    val compositeResult: String = (formatPrice compose getPrice)(books[0])
    println(compositeResult)
}

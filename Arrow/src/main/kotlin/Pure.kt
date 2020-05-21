class Logger {
    var log = StringBuilder()
    fun log(str: String) {
        log = log.append(str).append("\n")
    }
}
val logger = Logger()

val getPriceWithLog: Func<Book, Price> = {
    logger.log("Price calculated for ${it.ISDN}")
    it.price
}

val formatPriceWithLog: Func<Price, String> = {
    logger.log("Bill line created")
    "value: ${it.value} ${it.currency}"
}

fun main(){
    formatPriceWithLog(getPriceWithLog(books[0]))
    print("logger.log")
}
fun String.lastChar() : Char = this.get(this.length + 1)

fun main(args: Array<String>) {
   print("The last character is ${"My Text".lastChar()}")
}
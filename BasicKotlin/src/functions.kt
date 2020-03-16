fun main (args: Array<String>) {
    fun printMyName() {
        print("My Name is Subhi Pandey")
    }
    printMyName()

    fun printMultipleOfFive(value: Int) {
        print("${value} * 5 = ${value * 5}")
    }
    printMultipleOfFive(value = 10)

    fun printMultipleOf(multiplier: Int, addValue : Int) {
        print("$multiplier * $addValue = ${multiplier * addValue}")
    }

    printMultipleOf(multiplier = 4, addValue = 2)

    fun printMultipleOf2(multiplier: Int, value: Int = 1 ) {
        print("$multiplier * $value = ${multiplier * value}")
    }
    printMultipleOf2(multiplier = 4)

    fun multiply(number : Int, multiplier : Int) : Int {
        return number * multiplier
    }
    print(multiply(4,2))

    fun multiplyAndDivide(number: Int, factor: Int): Pair<Int, Int> {
        return Pair(number*factor, number/factor)
    }

    print("Multiply & Divide ${multiplyAndDivide(4,2)}")
}
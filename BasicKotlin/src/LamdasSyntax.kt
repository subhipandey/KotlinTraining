fun main(args: Array<String>) {
    fun handleInteger(myInt: Int, operation: (Int) -> Unit) {
        operation(myInt)
    }
    handleInteger(5,{print("My Result is ${it*10}")})
    handleInteger(5, {_ -> print("My Result is 10")})

    fun printResult(myInt : Int) {
        print("My Result is 10")

    }
    handleInteger(4, ::printResult )
}
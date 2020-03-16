typealias operation = (Int, Int) -> Int

fun main(args: Array<String>) {
    fun printMultipleOf(multiplier: Int, addValue : Int ) {}
    fun printMultipleOf(multiplier: Int, addValue : Int, thirdValue: Int) {}
    fun printMultipleOf(multiplier: Int, addValue : Int, thirdValue: Int, forthValue: Int ) {}

    fun getValue() : Int {
        return 31
    }

    fun getValueString() : String {
        return "Subhi Pandey"
    }

    fun add(a : Int, b: Int ) : Int {
        return a + b
    }

    var function : (Int, Int) -> Int = ::add

    print(function(4,2))

    fun subtract (a: Int, b: Int): Int {
        return a - b
    }
    function = ::subtract
    print(function(4,2))
    fun printResult(function: (Int, Int) -> Int, a: Int, b: Int) {
        val result = function(a,b)
        print(result)
}
    printResult(::add, a:4, b:2)

    fun printResult2(function:operation, a:Int, b:Int) {}

    fun noReturn() : Unit {

    }



}

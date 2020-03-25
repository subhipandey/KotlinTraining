sealed class Expression
data class Num(val number : Double) : Expression()
data class Sum(val el :Expression, val e2 : Expression) : Expression()
object NotANumber : Expression()

fun eval(expr: Expression) : Double = when(expr) {
    is Num -> expr.number
    is Sum -> eval(expr.el) + eval(expr.e2)
    NotANumber -> Double.NaN
}

fun main(args: Array<String>) {
      val num1 = Num(5.5)
      val num2 = Num(10.0)
   print("The sum of 5.5 and 10.0 is ${eval(Sum(num1, num2))}")
}
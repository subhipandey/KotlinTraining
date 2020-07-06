fun main(){
    var counter = 0
    val incrementCounter = {
        counter += 1
    }

    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    print(counter)

    fun countingLambda(): () -> Int {
        var counter = 0
        val incrementCounter: () -> Int = {
            counter += 1
            counter
        }
        return incrementCounter
    }

    val counter1 = countingLambda()
    val counter2 = countingLambda()

    print(counter1())
    print(counter1())

    print(counter2())
    print(counter2())
    print(counter2())
    print(counter2())
}
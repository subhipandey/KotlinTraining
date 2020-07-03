fun main() {
    fun createRange(start: Int, end: Int, isHalfOpen: Boolean= false): IntRange {
        return if (isHalfOpen) {
            start until end
        } else {
            start..end
        }

    }

    fun printRange(range:IntRange){
        for(number in range)print("$number \t")
        println()
    }
    val closedRange = createRange(1,18)
    printRange(closedRange)

    val halfOpenRange=createRange(1,18,true)
    printRange(halfOpenRange)

    val usingNamedArguments = createRange(isHalfOpen = true, start=30, end=15)
    printRange(usingNamedArguments)

    printRange(createRange(3,5,isHalfOpen = true))
}
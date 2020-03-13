fun main(args: Array<String>){
    val number = 10
    when (number){
        0 -> print("zero")
        10 -> print("Ten")
        else -> print("Non-Zero")

    }

    val string = "Dog"
    when (string) {
        "cat", "Dog" -> print("Animal is a house pet")
        else -> print("Animal is not a house pet")

    }

    when (number) {
        in 1..9 -> print("Between 1 and 9")
        in 10..20 -> print("Between 10 and 20")
        else -> print("some other number")

    }

    when {
        number % 2 == 0 -> print("Even")
        else -> print("Odd")
    }

    val testValue = 10
    val result = when {
        testValue < 10 -> "Less Than 10"
        testValue > 10 -> "Greater Than 10"
        else -> "is equal to 10"

    }
    print(result)
}
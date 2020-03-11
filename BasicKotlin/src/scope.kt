fun main(args: Array<String>) {
    var hoursWorked = 45
    var price = 0.0
    if (hoursWorked > 40) {
        val hoursOver40 = hoursWorked - 40
        price += hoursWorked * 50
        hoursWorked -= hoursOver40
    }

    price += hoursWorked * 25
    print(price)
}
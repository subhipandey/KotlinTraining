fun main(args: Array<String>) {


    val yes1: Boolean = true
    val no1: Boolean = false

    val yes2 = true
    val no2 = false

    print("yes1 = yes2 ${yes1 == yes2} no1*no2 ${no1 == no2}")

    val doesOneEqualTwo = (1==2)
    print("Does 1 equal 2 = ${doesOneEqualTwo} ")

    val doesOneNotEqualTwo = ( 1 !=2)
    print("Does 1 not Equal 2 = ${doesOneNotEqualTwo}")

    val longName = "Subhi".length > 5
    print("Longname = ${longName}")

    val and = true && true
    print("and = $and")

    val or = true || true
    print("or = $or")

    val guess = "dog"
    val dogEqualCat = guess == "cat"
    print("dogEqualCat ${dogEqualCat}")

    val a = 5
    val b = 10

    val min: Int
    if (a < 5) {
        min = a
    } else {
        min = b
    }

    print("min = $min")


}

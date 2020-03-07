fun main(args: Array<String>) {
    val coordinates = Pair(2, 3)
    val (x,y) = coordinates
    print("x = $x y = $y")

    print("x = ${coordinates.first} y = ${coordinates.second}")

    val coordinatesDouble = Pair(2.1, 3.5)
    print("x = ${coordinatesDouble.first} y = ${coordinatesDouble.second}")
}
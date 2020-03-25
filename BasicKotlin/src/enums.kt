enum class Direction {
    NORTH,SOUTH,WEST,EAST;

    fun printDirection() {
        print("I am going $this")
    }
}

enum class Color(val r: Int, q: Int, b: Int) {
    RED(255, 0, 0),
    YELLOW(255,255,0),
    GREEN(0, 255, 0)


}

fun drive(direction: Direction) {
    when (direction) {
        Direction.NORTH -> print("Driving North")
        Direction.WEST -> print("Driving West")
        Direction.EAST -> print("Driving East")
        Direction.SOUTH -> print("Driving South")


    }
}
fun main(args: Array<String>) {
    drive(Direction.NORTH)
    drive(Direction.WEST)

    print(Direction.NORTH.printDirection())

}
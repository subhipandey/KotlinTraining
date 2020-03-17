import sun.audio.AudioPlayer.player

fun main(args: Array<String>){
    val evenNumber = arrayOf(2,4,6,8)

    val evenNumber2 : Array<Int> = arrayOf(2,4,6,8)
    val intNumbers = intArrayOf(2,4,6,8)

    val players = arrayOf("Alice", "James","Cindy")

    if (players.size < 2) {
        print("We need at least two players")
    }else {
        print("Lets Start")
    }

    print(players.isEmpty())
    print(players.first())
    val firstPlayer = players[0]
    print("First Player is $firstPlayer")


    val upcomingPlayers = players.sliceArray(0..2)
    for (player in upcomingPlayers ) {
        print(player)
    }

    fun isEliminated(player: String) : Boolean {
        return !players.contains(player)
    }
    print(isEliminated("Bob"))
    print(isEliminated("Fred"))

    player[2] = "Sammy"
    for (player in players) {
        print(player)
    }

    fun sumOfAllItems(array: Array<Int>) : Int {
        var sum = 0
        for (number in array) {
           sum += number
        }
        return sum
    }
    print(sumOfAllItems(arrayOf(2,5,7)))

    val prices = arrayOf(1,5,20,50)
    val removeFirst = prices.drop(1)
    print(removeFirst)
    print(prices.drop)(n:2))
    print(prices.dropLast())(n:1))
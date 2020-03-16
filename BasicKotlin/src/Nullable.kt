fun main(args: Array<String>) {
    var nickname : String? = null

    fun printNickname(Nickname: String?) {
        print("My Nickname is $nickname")
    }

    printNickname(nickname)
    nickname = "Subhi"
    printNickname(nickname)
}
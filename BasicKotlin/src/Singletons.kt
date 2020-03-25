object MySingleton {
    fun doMyStuff(data: String ) {
        print("This is my $data")
    }

    val myConstant = "This is my constant"
}

fun main(args: Array<String>) {
  MySingleton.doMyStuff("Hello there" + MySingleton.myConstant)
}
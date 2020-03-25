class Person(var firstName:String, var lastName:String) {
    lateinit var fullName : String

    init {
        fullName = firstName + " " + lastName

    }

    fun printfullName() {
        if (!this::fullName.isInitialized) {
            fullName = firstName + " " + lastName
        }

        print(fullName)
    }
}


fun main(args: Array<String>) {

}
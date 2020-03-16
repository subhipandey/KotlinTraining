fun main(args: Array<String>) {
    var result : Int? = 30
    print(result)
    print(result)
    val newResult = result?.plus(5)

    var x: Int? = null
    if (x != null) {
        x += 1
    }
    print(result!! + 1)

    var authorName : String? = "Subhi Pandey"
    var authorAge: Int? = 30

    var unwrappedAuthorName = authorName!!
    print("Author is $unwrappedAuthorName")


    if (authorName != null) {
        print("Author is ${authorName!!}")
    } else {
        print("No Author")
    }

    authorName?.let { name ->
        print("Author is $name")
    }
    authorName?.let {
        print("Author is $it")
    }

    var nullableInt : Int? = 10
    var mustHaveResult = nullableInt ?: 0

}
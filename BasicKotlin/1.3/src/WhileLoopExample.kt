fun main() {
    /*
    * Challenge 1:
    * Print numbers from 1 to 15, using a while loop.
    *
    * Challenge 2:
    * Create an array or list of names. Using a do-while loop, and an iterator, print the names in a reverse order.
    * Make sure to check that the iterator is within the bounds of the array's size. (from `lastIndex` to 0).
    * */

    var index = 1
    while (index < 16){
        print(index)
        index += 1
    }

    val names = arrayOf("Subhi", "Rajesh", "Mohit", "Rivu")

    index = names.lastIndex
    do{
        if (index > names.lastIndex || index < 0) return

        print(names[index])
        index -=1

    }while (index > 0 && index < names.size)
}
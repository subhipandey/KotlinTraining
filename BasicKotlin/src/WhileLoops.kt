fun main (args: Array<String>) {
 //   while {
 //
 //   }

    var i = 1
    while (i < 10) {
        print(i)
        i + 1
    }
//    print("----")

//    do {

//    } while ()

    i = 1
    do {
        print(i)
        i += 1
    }while (i < 10)
    print("----")

    i=1
    do {
        print(i)
        if (i == 5) {
            break
        }
        i +=1
    }while (i < 10)
    print("After do")

}
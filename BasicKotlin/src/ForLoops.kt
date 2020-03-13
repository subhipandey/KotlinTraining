fun main(args: Array<String>) {
    val range = 0..5

//    for(/* condition in range */){
        // loop code
//    }

    val count = 10
    var sum = 0
    for (i in 1.. count){
        sum += i
    }
    print("sum = $sum")

    for (i in 0..count) {
        print("Test")
    }

    for (i in 1..count) {
        if (i %2 == 1)
            print("$i is a odd number")
    }

    for(i in 1..count){
        print("Hello")
        if (i==3){
            continue
        }
        print("Test1")
    }

    for (row in 1..3){
        for(column in 1..3) {
            print("$column")
        }
    }

    outer@ for (row in 1..3) {
        for (column in 1..3) {
            if (row == 2 && column == 2) {

                continue@outer
            }
            print("$column")
        }
    }

}
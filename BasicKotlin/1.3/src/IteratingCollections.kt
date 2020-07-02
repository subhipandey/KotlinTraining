fun main() {
    val daysOfWeek = listOf(
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    //iterating over loops

    for (day in daysOfWeek) {
        if (day == "Monday") {
            continue
        }
        print("Working")

        if (day == "Friday") {
            print("Get ready for the weekend!")
            break
        }
    }

    val matrix = MutableList(5) { MutableList(5) { "" } }

    for (row in 0..matrix.lastIndex) {
        for (column in 0..matrix.lastIndex) {
            matrix[row][column] = "$row:$column"
        }
    }

    print(matrix)
    print("===")

    for (row in matrix){
        print(row)

    }

    val thirdRowfifthColumnElement = matrix[2][4]
    print(thirdRowfifthColumnElement)

    row@ for (row in 0..5){
        column@ for (column in 0..5){
            if (column == 2 && row ==2){
                break@row
            }
            print("x\t")

        }


    }
}
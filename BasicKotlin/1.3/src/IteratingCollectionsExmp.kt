fun main() {
    /*
    * Challenge:
    * Simulate a game where you have to find the X in a matrix!
    *
    * Step 1: Choose the matrix size. E.g. 3x3
    * Step 2: Create the matrix (Hint: You can create an Array<Array<String>>, or a List<List<String>>).
    *
    * Step 3: Fill the matrix of your chosen size. When filling elements use the
    * '.' symbol for all of the elements, instead of 1 of your choice - e.g. the element in the third row,
    * second column in the matrix. For that element, put out the X symbol.
    *
    * Step 4: Create another nested loop which will find that element, and once it does, print its matrix coordinates.
    * Once you print the coordinates out, stop iterating over the matrix.
    * */

    val matrixRow = 5
    val matrixColumn = 8
    val matrix = Array(matrixRow) {Array(matrixColumn) {'.'} }

    matrix[3][6] = 'X'

  loop@  for (row in 0 until matrixRow){
        print("Searching in row $row")

        for(column in 0 until matrixColumn){
            if(matrix[row][column] == 'X'){
                print("Found X at: $row:$column")
                break@loop
            }
        }
    }
}
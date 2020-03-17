fun main (args: Array<String>) {
    /*
 ### Lists
 Create a list with the following states that you have lived in:
 */

    var states = mutableListOf<String>("Maharashtra", "Uttar Pradesh", "Bihar", "Delhi")
    states.add("Jammu And Kashmir")
    print(states)

    /*
Given a function to print out all states but the third index
*/

    fun printStates(states: List<String>) {
        for (i in 0..states.size-1) {
            if (i !=3) {
                print("$i ${states[i]}")
            }
        }

    }
    printStates(states)
}
import kotlin.properties.Delegates

data class Course(var map: Map<String,Any? >) {
    var room : String by map
    var teacher : String by map


}

fun main (args: Array<String>) {
   val course = Course(mapOf ("Room" to "Room 1", "teacher" to "Ms Price"))

    print(course)
}
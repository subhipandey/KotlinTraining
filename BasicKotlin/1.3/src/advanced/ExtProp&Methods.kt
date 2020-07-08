package advanced


import advanced.SimpleDate2.Companion.months
import sun.java2d.pipe.SpanShapeRenderer
import kotlin.math.PI
import kotlin.math.roundToInt
import kotlin.math.sqrt

//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---

class Circle2(var radius: Double = 0.0) {
    val circumference: Double
        get() = PI * radius * 2
}

//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---


// Add Circle Extension Property

val Circle.diameter: Double
    get() = 2.0 * radius


//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---

class SimpleDate2(var month: String) {
    fun monthsUntilJingleBells(): Int {
        return months.indexOf("December") - months.indexOf(month)
    }

    companion object {
        val months = arrayOf(
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        )
    }
}
//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---


// Add SimpleDate Extension Method

fun SimpleDate.monthUnitHalloweenDecorations(): Int {
    val currentMonths = SimpleDate.months.indexOf(month)
    val halloweenStart = SimpleDate.months.indexOf("September")
    val halloweenEnd = SimpleDate.months.indexOf("October")

    return if (currentMonths in 0..halloweenStart) {
        halloweenStart - currentMonths

    } else if (currentMonths in halloweenStart..halloweenEnd) {
        0
    } else {
        halloweenStart + (12 - currentMonths)
    }
}


//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---
class TVMath2 {
    companion object {
        fun getDiagonal(width: Double, height: Double): Int {
            val result = sqrt(width * width + height * height)
            return result.roundToInt()
        }

        fun getWidthAndHeight(diagonal: Int, ratioWidth: Double, ratioHeight: Double): Pair<Double, Double> {
            val ratioDiagonal = sqrt(ratioWidth * ratioWidth + ratioHeight * ratioHeight)
            val height = diagonal * ratioHeight / ratioDiagonal
            val width = height * ratioWidth / ratioHeight

            return Pair(width, height)
        }
    }
}
//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---


// Add TVMath Companion Object Extension Method

fun TVMath.Companion.idealViewingDistance(diagonal: Int, is4K: Boolean): Double {
    return if (is4K) diagonal * 1.25 else diagonal * 2.0

}

fun main() {

    val distance = TVMath.idealViewingDistance(diagonal = 65, is4K = true)
    print("sit $distance inches away")
    val date = SimpleDate("August")
    print("${date.monthUnitHalloweenDecorations()} months until spooky decorations")
    val unitCircle = Circle(1.0)
    print("diameter: ${unitCircle.diameter}")
}
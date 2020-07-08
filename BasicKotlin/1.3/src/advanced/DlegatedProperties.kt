package advanced

import kotlin.properties.Delegates

class Circle3(var radius: Double = 0.0) {
    val pi: Double by lazy { ((4.0 * kotlin.math.atan(1.0 / 5.0)) - kotlin.math.atan(1.0 / 239.0)) * 4.0 }
    val circumference: Double
        get() = pi * radius * 2
}

class Levels(val id: Int,
             val boss: String) {
    companion object {
        var highestLevel = 0
    }

    var unlocked: Boolean by Delegates.observable(false) { _, old, new ->
        if (new && id > highestLevel) {
            highestLevel = id
        }
    }
}

class Lamp{
    lateinit var bulb: Lightbulb
}

class Lightbulb {
    companion object {
        const val maxCurrent = 40
    }

    var current by Delegates.vetoable(0) { _, _, new ->
        if (new > maxCurrent) {
            print("Current too high, falling back to previous settings")
            false
        } else {
            true
        }
    }
}

fun main() {
    val circle3 = Circle(5.0)
    print(circle.circumference)
    val light = Lightbulb()
    light.current = 9000
    print(light.current)
    light.current = 40
    print(light.current)

    val fancyLamp = Lamp()
    fancyLamp.bulb = light
    print(fancyLamp.bulb)

    val level1 = Levels(id = 1, boss = "Outside Cat")
    val level2 = Levels(id = 2, boss = "Laser Pointer")
    val level3 = Levels(id = 3, boss = "Mysterious Attic Sound")
    val level4 = Levels(id = 4, boss = "Vacuum Cleaner")

    level1.unlocked = true
    println("Highest Level is ${Levels.highestLevel}")

    level4.unlocked = true
    println("Highest Level is ${Levels.highestLevel}")
}
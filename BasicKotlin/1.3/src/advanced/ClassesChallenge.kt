package advanced

import sun.awt.windows.WLightweightFramePeer

/*
Challenge 1 - Building a Class Hierarchy
Create a class named `Animal` that has…
1. a method named `speak()` that does nothing.

Create two `Animal` subclasses...
1. `WildAnimal` that...
  - has an `isPoisonous` property, that is a `Boolean`
2. `Pet` that...
  - has a stored property named `name`, that is a `String`
  - has a `play()` method that prints out a message
  - overrides `speak()` - It should print out a message

Create one subclass of your choice of `WildAnimal` or `Pet`. It should do at least one of the following:
 - override `speak()`
 - override `play()`
 - Add a new property with custom accessor
 - Add a new method
*/

open class Animal {
   open fun speak(){}
}

class WildAnimal(val isPoisonous: Boolean): Animal()

open class Pet: Animal{
    val name: String
    constructor(name: String){
        this.name = name
    }

    fun play(){
        println("Playtime! .. now naptime!")
    }

    override fun speak() {
        print("Hi i'm $name! i am cute. pet me!")
    }
}

class Cat(name: String): Pet(name){
    override fun speak() {
        println("I can have cheezburger")
    }
}




/*
Challenge 2 - Overriding & Polymorphism
- Write a function that takes an `Animal` and does something different depending on what subclass it is.
  You'll need to do some safe casting and null checks!
- Create at least one instance of each class from the first challenge.
- Create an array that contains all of the instances.
- Call the function with each of your instances using a loop or whatever other method you'd like!
*/

fun main() {

    fun printElevatorPitch(animal: Animal){
        when{
            (animal as? WildAnimal) != null -> {
                print(if (animal.isPoisonous)
                    "it's only a little poisonous!"
                else "It's not poisonous at all!"
                )
            }
            animal is Cat -> {
                print("It's a kitt name ${animal.name}! I've always wanted a kitty")
                animal.speak()
            }
            (animal as? Pet) != null -> {
                print("this is definetly a normal sort of a pet and i've named them ${animal.name}")
                animal.speak()
                animal.play()
            }

            else -> {println("Its Animal you know the muppet?")}
        }
    }

    val animal = Animal()
    val babyAragog = WildAnimal(isPoisonous = true)
    val babySmaug = WildAnimal(isPoisonous = false)
    val hamtaro = Pet(name = "Hamtaro")
    val ozma = Cat(name = "Ozma")

    val animals = arrayOf(animal, babyAragog, babySmaug, hamtaro, ozma)

    animals.forEach { printElevatorPitch(it) }

}
class Person(val name:String, val lastName:String?, var age:Int)

class Empty

fun main(){
 val subhi = Person("Subhi","Pandey",21)



    println("Name: ${subhi.name}, last name: ${subhi.lastName}, Age:${subhi.age}")

    val marin = Person("Marin",null, 21)
    print("Name: ${marin.name}, last name: ${marin.lastName}, Age:${marin.age}")

    val subhiClone = subhi

    subhiClone.age = 22
    print(subhi.age)
    print(subhiClone.age)

    val  subhiTwo = Person("Subhi", "Pandey", 24)

    print(subhi == marin)
    print(subhi == subhiClone)
    print(subhi === subhiClone)
    print(subhiTwo === subhi)
}
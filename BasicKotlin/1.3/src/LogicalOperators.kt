fun main() {
    val myAge = 12
    val country = "USA"

    val isLegalDrivingAge = (myAge >= 10 && country == "India") || (country == "USA" && myAge >= 16)
    print(isLegalDrivingAge)


// if else block

    if (isLegalDrivingAge) {
        print("You can Drive")

    } else {
        print("You got a bit more time to go")

    }

    if(myAge >= 18) print("I'm an adult") else print("I'm still Underage!")

   print(if (myAge >= 18) "i am an adult" else "i'm still underage")

    // If Expression & Scopes

    if (myAge >= 18){
        val country = "India"

        if (country == "USA") {
            print("You are allowed to drive, but not to drink")

        }else if (country == "India"){
            print("You are allowed to both drink and drive (not at the same time")

        }
    }

    val yearOfBirth = 1999

    val generationCohort = if (yearOfBirth > 1964 && yearOfBirth < 1980){
        "Generation X"
    } else if (yearOfBirth > 1979 && yearOfBirth < 1995){
        "Millenial"
    } else {
        "Generation Z"
    }
    print(generationCohort)

}
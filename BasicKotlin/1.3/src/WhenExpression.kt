fun main() {
    val myAge = 21

    //When with parameter
   val message = when(myAge){
       in 0..12 -> "Still a young boy"
        in 12..19 -> "Teenager"
        in 20..29 -> "In my twenties"
        in 30..39-> "in my thirties"
        in 40..49 -> "In my forties"
        else -> "I am a wise man"
    }
    print(message)

    //when without parameter

    val email: String? = "email@mail.com"
    val password: String? = "KotlinGuy"

    when {
        email == null ||email.isEmpty() -> {
            print("You need to choose a email")
        }

        "0" !in email ->print("Your email is invalid!")


        password == null || password.isEmpty() -> {
           print("You need to choose a password")
        }

        password.length < 18 -> {
            print("password not string enough ")
        }

        else ->{
            print("Email length: ${email.length}, password length: ${password.length}")
        }
    }
}
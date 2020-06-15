fun main(){
    val myName = "Subhi"
    val nickname: String? = null
    val lastname: String? = null
    print(nickname)

    val nicknameLength = nickname?.length?.toDouble()
    print(nicknameLength)

    if(lastname != null) {
        print("My last name is ${lastname.length} characters long")
    }else{
        print("I don't have a last name")
    }

    if (nickname?.isEmpty() == true){
        print("You don't have a nickname! It's length is ${nickname.length}")
    }

    //val notNullNickname = requireNotNull(nickname)
   // print(notNullNickname.length)

    val myNickname = nickname ?: myName
    print(myNickname)

    val lastBirthdayYear = 2020
    val myAge: Int? = 20

    val myAgeNotNull = myAge ?: return

    val yearOfBirth = lastBirthdayYear - myAgeNotNull
    print("I was born in $yearOfBirth")
}
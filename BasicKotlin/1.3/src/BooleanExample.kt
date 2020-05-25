fun main(){
    /*
 * Challenge 1:
 * Check and store in a Boolean if a password is secure.
 * For simplicity, we can say that a password is secure if it has
 * at least 10 characters.
 * */

    val myPassword = "y0GhbyT112ABB"

    val isPasswordSecure = myPassword.length >=10
    print(isPasswordSecure)


    /*
    * Challenge 2:
    * Check if two people have the same name length.
    * */

    val myName = "Subhi"
    val strangerName = "Raj"

    val areSameLength = myName.length == strangerName.length
    print(areSameLength)
}
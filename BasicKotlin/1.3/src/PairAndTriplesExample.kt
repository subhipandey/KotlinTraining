/*
* Create a Pair which holds information about a Bank Account.
* A Bank Account needs to have a Credit Card connected to it, and a balance. (Hint: You can nest a Triple in a Pair)
* A Credit Card should have a Card number, security code, and the type of the card (e.g. "Visa", "MasterCard").
*
* Print out the data for the Account, while hiding the security code.
* */

fun main(){

    val creditCard = Triple("256780909090","010","MasterCard")
    val bankAccount = Pair(250000.0, creditCard)

    val (balance:Double, card:Triple<String,String,String>) = bankAccount
    val(cardNumber:String, securityCode:String, cardType: String) = card


    print("The account has $$balance, with the cardNumber: $cardNumber and the cardTypes: $cardType, security: ***")
}
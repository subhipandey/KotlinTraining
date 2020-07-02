fun main(){
    val userIds = setOf("1D18","ID2C", "ID3F", "ID8I")
    print(userIds)

    print(userIds.contains("ID3F"))
    print("ID1B" in userIds)

    val mutableIds = userIds.toMutableSet()

    print(mutableIds.add("ID0Z"))
    print(mutableIds)

    print(mutableIds.add("ID1B"))
    print(mutableIds)

    print(mutableIds.remove("ID1B"))

    for (userId in mutableIds){
        print(userId)
    }
    val names = arrayOf("Phillip", "Mark", "Joe", "John", "Phllip")
    print(names)

    val uniqueNames = names.toSet()


    print(uniqueNames)
}
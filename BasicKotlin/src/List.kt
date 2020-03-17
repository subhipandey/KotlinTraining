fun main(args: Array<String>){
    val names = listOf("Anna", "Brain", "Craig", "Donna")
    print(names)

    val teamNames = mutableListOf<String>()
    teamNames.addAll(names)
    print(teamNames)

    teamNames.add("Sam")
    teamNames.add("jan")
    print(teamNames)

    print(names[0])

    print(names.indexOf("Brain"))

    teamNames.remove("Craig")
    print(teamNames)

    for(name in teamNames) {
        print("Team Member: $name")
    }
}
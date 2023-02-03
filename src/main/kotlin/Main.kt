fun main() {
    println("MENU")
    println("")
    println("1 - Vowel Counter")
    println("2 - Palindrome")
    println("3 - Fibonacci")
    println("4 - Anagram")
    println("5 - Rock, Paper, Scissors")
    println("6 - Exit")
    println("")
    println("What project would you like to do?")
    print(": ")

    try {
        when (readln().toInt()) {
            1 -> vowels()
            2 -> palindrome()
            3 -> fibonacci()
            4 -> anagram()
            5 -> rps()
            6 -> println("Exiting...")
            else -> {
                println("Invalid value")
                main()
            }
        }

    } catch (exception: NumberFormatException) {
        println("Invalid value")
        main()
    }

}

fun vowels() {

    println("Please type your sentence: ")
    val stc = readln().lowercase().toCharArray().count { it in "aeiou" }

    println("Total number of vowels = $stc")
    main()
}

fun palindrome() {
    println("Insert the word to be checked: ")
    val word = readln()

    val list = word.toList()

    val reverse = list.reversed()

    if (list == reverse) {
        println("'$word' is a Palindrome")
    } else {
        println("'$word' is not a palindrome")
    }
    main()
}

fun fibonacci() {

    println("Insert amount of elements: ")
    val n = readln().toInt()

    var num1 = 1
    var num2 = 0
    val fib = arrayListOf<Int>()

    for (i in 1..n) {
        fib.add(num1)

        val sum = num1 + num2
        num2 = num1
        num1 = sum
    }

    println(fib)
    main()
}

fun anagram() {
    println("Insert the first word: ")
    val s = readln().lowercase()

    println("Insert the second word: ")
    val t = readln().lowercase()

    if (isAnagram(s, t)) println("The words are anagrams of each other")
    else println("The words are not anagrams of each other")
    main()
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val map = HashMap<Char, Int>()

    val sArray = s.toCharArray()
    val tArray = t.toCharArray()

    for (c in sArray) {
        map[c] = map.getOrDefault(c, 0) + 1
    }

    for (c in tArray) {
        var current = map.getOrDefault(c, 0)
        if (current < 1) return false
        map[c] = --current
    }

    return true
}

fun rps() {
    println("1")
    Thread.sleep(500)
    println("2")
    Thread.sleep(500)
    println("3")
    Thread.sleep(500)
    println("Rock, Paper, Scissors!")
    print(": ")

    val user = readln().lowercase()

    if (user != "rock" && user != "paper" && user != "scissors") {
        println("Invalid option!")

    } else {

        when (rps2(user)) {
            1 -> println("You won!")
            2 -> println("Its a tie!")
            3 -> println("You lost!")
        }
    }
    main()
}

fun rps2(user: String): Int {

    val values = arrayOf("rock", "paper", "scissors")

    val pc = values.random()

    return if (pc == "rock" && user == "paper" || pc == "scissors" && user == "rock" || pc == "paper" && user == "scissors") {
        println("PC chose $pc!")
        Thread.sleep(500)
        1
    } else if (pc == user) {
        println("PC chose $pc!")
        Thread.sleep(500)
        2
    } else {
        println("PC chose $pc!")
        Thread.sleep(500)
        3
    }

}
package com.problemsolving.other

fun main() {

//    println(checkPalindrome("suleman"))
//    println(checkPalindrome("mom"))
    println(checkPalindromeUsingMap("ninjit"))

}

fun checkPalindromeUsingMap(data: String): Boolean {
    var oddCount = 0
    val hashMap = mutableMapOf<Char, Int>()
    for (i in 0 until data.length) {
        val count = hashMap.getOrDefault(data[i], 0)
        hashMap[data[i]] = count + 1
    }

    for ((key, count) in hashMap) {
        if (count == 1) {
            oddCount++
        }
        if (oddCount > 1) {
//if more than one odd count are there, its cannot become palindrome after rearrangement
            return false
        }

    }
    return true
}
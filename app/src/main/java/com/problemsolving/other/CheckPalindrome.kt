package com.problemsolving.other

fun main() {

//    println(checkPalindromeUsingList("suleman"))
    println(checkPalindromeUsingList("mom"))
//    println(checkPalindromeUsingList("niint"))

}

fun checkPalindromeUsingList(data: String): Boolean {
    //Time - O(n), space - O(n)
    var list = mutableListOf<Char>()
    for (i in 0 until data.length) {
        if (list.contains(data[i]))
            list.remove(data[i])
        else
            list.add(data[i])
    }
    return if (data.length % 2 == 0) {
        list.isEmpty()
    } else {
        list.size == 1
    }
}

fun checkPalindromeUsingMap(data: String): Boolean {
    //Time - O(n), space - O(n)
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

/**
 * https://www.geeksforgeeks.org/check-characters-given-string-can-rearranged-form-palindrome/
 * to solve problem in
 * o(n) time and o(1) space
 * refer this link for bits implementation
 */
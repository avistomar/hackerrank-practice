package com.avistomar.hackerrankpractice

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HackerrankPracticeApplication

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = Array<Int>(arrCount, { 0 })
    for (i in 0 until arrCount) {
        val arrItem = readLine()!!.trim().toInt()
        arr[i] = arrItem
    }

    val result = minimalHeaviestSetA(arr)

    println(result.joinToString("\n"))
}

fun minimalHeaviestSetA(arr: Array<Int>): Array<Int> {
    // Write your code here

    val setA = mutableSetOf<Int>()
    val setB = arr.toMutableSet()
    val possibleSets = mutableSetOf<Set<Int>>()

    val count = setB.size
    for (i in 1..count) {
        val maxNum = setB.maxOrNull()!!
        setA.add(maxNum)
        setB.remove(maxNum)
        if (setA.sum() > setB.sum()) {
            return setA.toTypedArray().sortedArray()
        }
    }

    return return setA.toTypedArray().sortedArray()
}

private fun checkMaxSet(possibleSets: Set<Set<Int>>): Set<Int> {
    var maxSet = setOf<Int>()
    var maxSum = 0

    possibleSets.forEach { set ->
        if (maxSum < set.sum()) {
            maxSet = set
            maxSum = set.sum()
        }
    }

    return maxSet
}

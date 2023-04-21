package com.avistomar.hackerrankpractice

/*
 * Complete the 'getTotalX' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER_ARRAY b
 */

fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    val listA = a.toList()
    val listB = b.toList()
    val tempList = mutableListOf<Int>()
    val resultList = mutableListOf<Int>()

    val start = listA.maxOrNull()!!
    val end = listB.minOrNull()!!

    if (start > end) return 0

    for (x in start..end) {
        var flag = 1
        for (i in listA) {
            if (x%i !=0) {
                flag = 0
                break
            }
        }
        if (flag == 1) tempList.add(x)
    }

    for (x in tempList) {
        var flag = 1
        for (i in listB) {
            if (i%x != 0) {
                flag = 0
                break
            }
        }
        if (flag == 1) resultList.add(x)
    }

    return resultList.size
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val brr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val total = getTotalX(arr, brr)

    println(total)
}

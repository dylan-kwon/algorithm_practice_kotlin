package backjoon.greedy

import kotlin.system.exitProcess

fun main() {
    val s = readln().toLong()
    if (s == 1L) {
        println(1)
        exitProcess(0)
    }

    var sum = 0L
    var count = 0L

    for (i in 1 until s) {
        val newSum = sum + i
        if (newSum > s) {
            break
        }
        count++
        sum = newSum
    }
    println(count)
}

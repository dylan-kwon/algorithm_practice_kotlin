package backjoon.greedy

import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val values = mutableListOf<Int>().apply {
        repeat(n) {
            val value = readln().toInt()
            add(value)
        }
    }.sorted()

    var max = 0

    for ((i, value) in values.withIndex()) {
        val w = value * (n - i)
        if (max < w) {
            max = w
        }
    }
    println(max)
}

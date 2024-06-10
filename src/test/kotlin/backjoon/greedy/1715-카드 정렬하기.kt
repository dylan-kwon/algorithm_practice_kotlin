package backjoon.greedy

import java.util.*

fun main() {
    val n = readln().toInt()
    val packs = PriorityQueue(
        List(n) {
            readln().toLong()
        }
    )

    var result = 0L

    while (packs.size > 1) {
        val a = packs.poll()
        val b = packs.poll()
        val c = a + b

        result += c
        packs.offer(c)
    }

    println(result)
}

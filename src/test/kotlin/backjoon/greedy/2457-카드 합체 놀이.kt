package backjoon.greedy

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map {
        it.toInt()
    }
    val cards = PriorityQueue(
        readln().split(" ").map {
            it.toLong()
        }
    )

    repeat(m) {
        val a = cards.poll()
        val b = cards.poll()
        val c = a + b

        cards.offer(c)
        cards.offer(c)
    }

    print(cards.sum())
}

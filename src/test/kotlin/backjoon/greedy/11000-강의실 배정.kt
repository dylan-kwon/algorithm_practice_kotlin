package backjoon.greedy

import java.util.*

fun main() {
    val n = readln().toInt()
    val schedules = List(n) {
        readln().split(" ").map {
            it.toInt()
        }
    }.sortedWith(
        compareBy<List<Int>> {
            it[0]
        }.thenBy {
            it[1]
        }
    )

    val queue = PriorityQueue<Int>().apply {
        offer(schedules.first().last())
    }

    for ((start, end) in schedules.subList(1, n)) {
        if (start >= queue.peek()) {
            queue.poll()
        }
        queue.offer(end)
    }

    print(queue.size)
}
package backjoon.greedy

import java.util.*

fun main() {
    val n = readln().toInt()
    val tasks = List(n) {
        readln().split(" ").map {
            it.toInt()
        }
    }.sortedBy {
        it.first()
    }.groupBy {
        it.first()
    }

    val maxDay = tasks.keys.last()

    var result = 0
    val pq = PriorityQueue<Int>(compareBy { -it })

    for (day in maxDay downTo 1) {
        tasks[day]?.forEach {
            pq.offer(it.last())
        }
        if (pq.isNotEmpty()) {
            result += pq.poll()
        }
    }

    println(result)
}

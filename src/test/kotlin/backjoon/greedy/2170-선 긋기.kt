package backjoon.greedy

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val lines = List(n) {
        readln().split(" ").map {
            it.toLong()
        }
    }.sortedBy {
        it.first()
    }

    val startLine = lines.first()
    var tempStart = startLine.first()
    var tempEnd = startLine.last()

    var result = 0L

    for (i in 1 until lines.size) {
        val (start, end) = lines[i]
        if (start <= tempEnd) {
            if (end > tempEnd) {
                tempEnd = end
            }
        } else {
            result += (tempEnd - tempStart)
            tempStart = start
            tempEnd = end
        }
    }
    result += abs(tempEnd - tempStart)

    println(result)
}
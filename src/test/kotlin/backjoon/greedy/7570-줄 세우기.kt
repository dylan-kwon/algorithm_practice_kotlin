package backjoon.greedy

fun main() {
    val (_, m) = readln().split(" ").map {
        it.toInt()
    }
    val numbers = readln().split(" ").map {
        it.toInt()
    }
    var sum = 0L
    val sumNumbers = mutableListOf<Long>().apply {
        for (number in numbers) {
            sum += number
            this += sum
        }
    }
    val tasks = List(m) {
        readln().split(" ").map {
            it.toInt()
        }
    }
    for ((i, j) in tasks) {
        val result = if (i == 1) {
            sumNumbers[j - 1]
        } else {
            sumNumbers[j - 1] - sumNumbers[i - 2]
        }
        println(result)
    }
}
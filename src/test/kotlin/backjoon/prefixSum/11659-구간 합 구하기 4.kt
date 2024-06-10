package backjoon.prefixSum

fun main() {
    val (n, m) = readln().split(" ").map {
        it.toInt()
    }
    val numbers = readln().split(" ").map {
        it.toInt()
    }

    val sumNumbers = IntArray(n + 1).apply {
        var sum = 0
        for (i in 1..n) {
            sum += numbers[i - 1]
            this[i] = sum
        }
    }
    val tasks = List(m) {
        readln().split(" ").map {
            it.toInt()
        }
    }
    for ((i, j) in tasks) {
        val result = sumNumbers[j] - sumNumbers[i - 1]
        println(result)
    }
}
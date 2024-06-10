package backjoon.prefixSum

fun main() {
    val (n, m) = readln().split(" ").map {
        it.toInt()
    }

    val graph = List(n) {
        readln().split(" ").map {
            it.toInt()
        }
    }

    val sumGraph = Array(n + 1) {
        IntArray(n + 1)
    }.apply {
        for (i in 1..n) {
            for (j in 1..n) {
                this[i][j] = this[i - 1][j] +
                        this[i][j - 1] -
                        this[i - 1][j - 1] +
                        graph[i - 1][j - 1]
            }
        }
    }

    val tasks = List(m) {
        readln().split(" ").map {
            it.toInt()
        }
    }

    for ((fromX, fromY, toX, toY) in tasks) {
        val result = sumGraph[toX][toY] -
                sumGraph[toX][fromY - 1] -
                sumGraph[fromX - 1][toY] +
                sumGraph[fromX - 1][fromY - 1]

        println(result)
    }
}
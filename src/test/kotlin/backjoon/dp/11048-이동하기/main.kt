package backjoon.dp.`11048-이동하기`

fun main() {
    val (n, m) = readln().split(" ").map {
        it.toInt()
    }

    val graph = Array(n + 1) {
        IntArray(m + 1)
    }.apply {
        for (i in 1..n) {
            readln().split(" ").map {
                it.toInt()
            }.forEachIndexed { j, value ->
                this[i][j + 1] = value
            }
        }
    }

    val dp = Array(n + 1) {
        IntArray(m + 1)
    }

    for (i in 1..n) {
        for (j in 1..m) {
            dp[i][j] = graph[i][j] + listOf(
                dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]
            ).max()
        }
    }

    println(dp[n][m])
}

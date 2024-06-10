package backjoon.dp.`1890-점프`

fun main() {
    val n = readln().toInt()
    val graph = Array(n) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }
    val dp = Array(n) {
        LongArray(n)
    }.apply {
        this[0][0] = 1
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            val jump = graph[i][j]
            if (jump == 0) {
                continue
            }
            val nextI = i + jump
            val nextJ = j + jump

            if (nextI < n) {
                dp[nextI][j] += dp[i][j]
            }
            if (nextJ < n) {
                dp[i][nextJ] += dp[i][j]
            }
        }
    }

    println(
        dp[n - 1][n - 1]
    )
}
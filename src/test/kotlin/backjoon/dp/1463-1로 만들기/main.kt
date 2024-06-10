package backjoon.dp.`1463-1로 만들기`

import kotlin.math.min

fun main() {
    val n = readln().toInt()
    println(dp(n))
    println(bfs(n))
}

private fun dp(n: Int): Int {
    val dp = IntArray(n + 1) {
        0
    }
    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1

        if (i % 2 == 0) {
            dp[i] = min(dp[i], dp[i / 2] + 1)
        }
        if (i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1)
        }
    }
    return dp[n]
}

private fun bfs(n: Int): Int {
    val queue = ArrayDeque<Data>().apply {
        add(Data(n, 0))
    }
    val visited = BooleanArray(n + 1) {
        false
    }
    while (queue.isNotEmpty()) {
        val data = queue.removeFirst()
        if (data.number == 1) {
            return data.count
        }
        if (visited[data.number]) {
            continue
        }
        visited[data.number] = true

        val nextCount = data.count + 1

        if (data.number % 2 == 0) {
            queue.add(
                Data(data.number / 2, nextCount)
            )
        }
        if (data.number % 3 == 0) {
            queue.add(
                Data(data.number / 3, nextCount)
            )
        }
        queue.add(
            Data(data.number - 1, nextCount)
        )
    }
    return -1
}

private data class Data(
    val number: Int,
    val count: Int,
)
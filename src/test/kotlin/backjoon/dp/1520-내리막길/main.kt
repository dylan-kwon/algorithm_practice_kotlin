package backjoon.dp.`1520-내리막길`

private val distances = listOf(
    intArrayOf(-1, 0),
    intArrayOf(1, 0),
    intArrayOf(0, 1),
    intArrayOf(0, -1),
)

fun main() {
    val (m, n) = readln().split(" ").map {
        it.toInt()
    }
    val map = Array(m) {
        readln().split(" ").map {
            it.toInt()
        }.toIntArray()
    }
    val dp = Array(m) {
        IntArray(n) { -1 }
    }.apply {
        this[0][0] = 1
    }

    fun dfs(i: Int, j: Int): Int {
        if (dp[i][j] == -1) {
            dp[i][j] = 0
            for ((di, dj) in distances) {
                val pi = i + di
                val pj = j + dj

                if (pi !in 0 until m) {
                    continue
                }
                if (pj !in 0 until n) {
                    continue
                }
                if (map[i][j] >= map[pi][pj]) {
                    continue
                }
                dp[i][j] += dfs(pi, pj)
            }
        }
        return dp[i][j]
    }

    println(
        dfs(m - 1, n - 1)
    )
}
package backjoon.dp.`11057-쉬운 계단 수`

fun main() {
    val n = readln().toInt()
    println(dp(n))
}

private fun dp(n: Int): Long {
    val dp = Array(n + 1) {
        LongArray(10) { 0 }
    }.apply {
        for (i in 1..9) {
            this[1][i] = 1
        }
    }
    for (i in 2..n) {
        for (j in 0..9) {
            when (j) {
                0 -> {
                    dp[i][j] = dp[i - 1][1] % 1_000_000_000
                }

                9 -> {
                    dp[i][j] = dp[i - 1][8] % 1_000_000_000
                }

                else -> {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000
                }
            }
        }
    }
    return dp[n].sum() % 1_000_000_000
}
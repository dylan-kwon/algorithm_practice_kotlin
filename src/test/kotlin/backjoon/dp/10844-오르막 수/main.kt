package backjoon.dp.`10844-오르막 수`

fun main() {
    val n = readln().toInt()
    println(dp(n))
}

private fun dp(n: Int): Int {
    val dp = Array(n + 1) {
        IntArray(10)
    }.apply {
        repeat(10) {
            this[1][it] = 1
        }
    }
    for (i in 2..n) {
        for (j in 0..9) {
            for (k in 0..j) {
                dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007
            }
        }
    }
    return dp[n].sum() % 10007
}
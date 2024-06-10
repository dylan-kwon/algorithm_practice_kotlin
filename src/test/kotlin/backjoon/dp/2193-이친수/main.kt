package backjoon.dp.`2193-이친수`

fun main() {
    val n = readln().toInt()
    val dp = Array(n + 1) {
        LongArray(2)
    }.apply {
        this[1][1] = 1
    }
    for (i in 2..n) {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
        dp[i][1] = dp[i - 1][0]
    }
    println(dp[n].sum())
}
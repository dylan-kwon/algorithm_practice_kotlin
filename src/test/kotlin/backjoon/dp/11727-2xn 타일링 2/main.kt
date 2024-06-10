package backjoon.dp.`11727-2xn 타일링 2`

fun main() {
    println(dp())
}

private fun dp(): Int {
    val n = readln().toInt()
    val dp = IntArray(1001).apply {
        set(1, 1)
        set(2, 3)
    }
    if (n > 2) {
        for (i in 3..n) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007
        }
    }
    return dp[n]
}
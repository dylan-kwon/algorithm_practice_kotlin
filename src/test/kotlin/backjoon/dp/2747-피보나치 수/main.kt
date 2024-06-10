package backjoon.dp.`2747-피보나치 수`

fun main() {
    val n = readln().toInt()
    if (n < 2){
        println(n)
        return
    }

    val dp = Array<Long>(n + 1) {
        0
    }.apply {
        set(0, 0)
        set(1, 1)
    }

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    println(dp[n])
}
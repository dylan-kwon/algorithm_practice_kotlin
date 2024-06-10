package backjoon.greedy

fun main() {
    val t = readln().toInt()

    val a = 5 * 60
    val b = 1 * 60
    val c = 10

    if (t % c == 0) {
        val aCnt = t / a
        val bCnt = t % a / b
        val cCnt = t % a % b / c

        println("$aCnt $bCnt $cCnt")

    } else {
        println(-1)
    }
}

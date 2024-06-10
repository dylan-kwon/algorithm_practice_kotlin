package backjoon.greedy

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map {
        it.toInt()
    }.sorted()

    val b = readln().split(" ").map {
        it.toInt()
    }

    val s = run {
        var sum = 0
        repeat(n) {
            sum += (a[it] * b[it])
        }
        sum
    }

    println(s)
}

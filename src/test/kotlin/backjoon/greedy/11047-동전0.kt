package backjoon.greedy

fun main() {
    var (n, k) = readln().split(" ").map {
        it.toInt()
    }
    val values = mutableListOf<Int>().apply {
        repeat(n) {
            val value = readln().toInt()
            add(value)
        }
    }.sortedDescending()

    var result = 0
    for (value in values) {
        if (k < value) {
            continue
        }
        result += k / value
        k %= value
        if (k == 0) {
            break
        }
    }
    print(result)
}

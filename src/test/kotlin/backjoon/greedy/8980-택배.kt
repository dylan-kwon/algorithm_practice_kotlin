package backjoon.greedy

fun main() {
    val (n, c) = readln().split(" ").map {
        it.toInt()
    }
    val m = readln().toInt()
    val tasks = List(m) {
        readln().split(" ").map {
            it.toInt()
        }
    }.sortedBy {
        it[1]
    }

    val free = List(n) {
        c
    }.toMutableList()

    var result = 0

    for ((from, to, count) in tasks) {
        var min = c
        for (i in from until to) {
            val calc = free[i].coerceAtMost(count)
            if (calc < min) {
                min = calc
            }
        }
        for (i in from until to) {
            free[i] -= min
        }
        result += min
    }

    println(result)
}

package backjoon.greedy

fun main() {
    val n = readln().toInt()
    val dates = mutableListOf<List<Int>>().apply {
        repeat(n) {
            this += readln().split(" ").map {
                it.toInt()
            }
        }
    }.sortedWith(compareBy<List<Int>> {
        it[0]
    }.thenBy {
        it[1]
    }.thenBy {
        it[2]
    }.thenBy {
        it[3]
    }).toMutableList()

    var currentEndMonth = 3
    var currentEndDay = 1

    var result = 0
    var success = false

    while (true) {
        val next = dates.filter {
            val (startMonth, startDay, _, _) = it
            startMonth < currentEndMonth || (startMonth == currentEndMonth && startDay <= currentEndDay)
        }.maxWithOrNull(compareBy<List<Int>> {
            it[2]
        }.thenBy {
            it[3]
        })

        if (next == null) {
            break
        }

        val (_, _, endMonth, endDay) = next
        dates.remove(next)

        currentEndMonth = endMonth
        currentEndDay = endDay

        result++

        if (endMonth >= 12) {
            success = true
            break
        }
    }
    println(
        when (success) {
            true -> result
            else -> 0
        }
    )
}

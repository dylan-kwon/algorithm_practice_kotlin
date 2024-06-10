package backjoon.greedy

fun main() {
    val n = readln().toInt()
    val schedules = mutableListOf<List<Int>>().apply {
        repeat(n) {
            this += readln().split(" ").map {
                it.toInt()
            }
        }
    }.sortedWith(compareBy({
        it.last()
    }, {
        it.first()
    }))

    var count = 0
    var currentEnd = -1

    for (schedule in schedules) {
        val start = schedule.first()
        if (start >= currentEnd) {
            count++
            currentEnd = schedule.last()
        }
    }
    println(count)
}

package backjoon.greedy

fun main() {
    val n = readln().toInt()
    val points = IntArray(n) {
        readln().toInt()
    }.reversed()

    var max = points.first()
    var result = 0

    for (point in points.subList(1, n)) {
        if (point >= max) {
            val change = point - max + 1
            result += change
            max = point - change
        } else {
            max = point
        }
    }

    println(result)

}

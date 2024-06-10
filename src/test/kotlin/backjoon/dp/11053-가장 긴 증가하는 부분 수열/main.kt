package backjoon.dp.`11053-가장 긴 증가하는 부분 수열`

fun main() {
    val n = readln().toInt()
    val values = readln().split(" ").map {
        it.toInt()
    }
    var result = 0

    var temp = -1
    for (value in values) {
        if (value < temp) {
            continue
        }
        temp = value
        result++
    }
    println(result)
}
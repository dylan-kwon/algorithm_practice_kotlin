package backjoon.greedy

fun main() {
    val input = readln()
    val parts = input.split("-")

    var result = Int.MAX_VALUE

    for (part in parts) {
        val sum = part.split("+").sumOf {
            it.toInt()
        }
        if (result == Int.MAX_VALUE) {
            result = sum
        } else {
            result -= sum
        }
    }

    println(result)
}

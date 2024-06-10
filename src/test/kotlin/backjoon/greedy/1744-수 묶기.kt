package backjoon.greedy

fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) {
        readln().toInt()
    }

    var result = 0

    val pNumbers = numbers.filter {
        it > 0
    }.sortedDescending()

    val nNumbers = numbers.filter {
        it <= 0
    }.sorted()

    for (pair in pNumbers.chunked(2)) {
        if (pair.size == 2 && pair.all { it > 1 }) {
            result += pair.first() * pair.last()
        } else {
            result += pair.first()
            result += pair.getOrElse(1) { 0 }
        }
    }

    for (pair in nNumbers.chunked(2)) {
        if (pair.size == 2) {
            result += pair.first() * pair.last()
        } else {
            result += pair.first()
        }
    }


    println(result)
}

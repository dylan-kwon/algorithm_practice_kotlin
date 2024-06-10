package backjoon.greedy

fun main() {
    val n = readln().toLong()

    val distances = readln().split(" ").map {
        it.toLong()
    }

    val prices = readln().split(" ").map {
        it.toLong()
    }

    var result = 0L
    var minPrice = Long.MAX_VALUE

    for ((i, price) in prices.dropLast(1).withIndex()) {

        if (price < minPrice) {
            minPrice = price
        }
        result += minPrice * distances[i]
    }

    println(result)
}

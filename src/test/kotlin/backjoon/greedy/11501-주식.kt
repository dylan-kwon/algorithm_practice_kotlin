package backjoon.greedy

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val prices = readln().split(" ").map {
            it.toInt()
        }.reversed()

        var result = 0L
        var maxPrice = prices.first()

        for (price in prices) {
            if (price > maxPrice) {
                maxPrice = price
            } else {
                result += maxPrice - price
            }
        }
        println(result)
    }
}

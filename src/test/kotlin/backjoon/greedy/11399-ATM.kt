package backjoon.greedy

fun main() {
    readln()

    val pValues = readln().split(" ").map {
        it.toInt()
    }.sorted()
        .toMutableList()

    for ((i, v) in pValues.withIndex()) {
        if (i == 0) {
            continue
        }
        pValues[i] = pValues[i - 1] + v
    }

    println(pValues.sum())
}

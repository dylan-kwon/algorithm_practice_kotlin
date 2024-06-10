package backjoon.prefixSum

fun main() {
    val (n, m) = readln().split(" ").map {
        it.toInt()
    }
    val numbers = readln().split(" ").map {
        it.toInt()
    }
    val sumNumbers = mutableListOf<Int>().apply {
        var sum = 0
        for (number in numbers) {
            sum += number
            this += sum
        }
    }

    var result = 0
    val indexes = IntArray(n) {
        it
    }.toList()

    for (number in numbers) {
        if (number % m == 0) {
            result++
        }
    }

    for (combination in combination(indexes, 2)) {
        val startIndex = combination.first()
        val endIndex = combination.last()

        val sum = if (startIndex == 0) {
            sumNumbers[endIndex]
        } else {
            sumNumbers[endIndex] - sumNumbers[startIndex - 1]
        }

        if (sum % m == 0) {
            result++
        }
    }

    println(result)
}

fun <T> combination(list: List<T>, count: Int): List<List<T>> {
    val result = mutableListOf<List<T>>()
    val subList = mutableListOf<T>()

    fun run(start: Int) {
        if (subList.size == count) {
            result.add(subList.toList())
            return
        }
        for (i in start until list.size) {
            subList.add(list[i])
            run(i + 1)
            subList.removeLast()
        }
    }
    run(0)
    return result
}
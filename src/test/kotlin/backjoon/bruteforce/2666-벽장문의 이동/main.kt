package backjoon.bruteforce.`2666-벽장문의 이동`

private val results = mutableListOf<Int>()

fun main() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map { it.toInt() }
    val length = readln().toInt()
    val orderOfUse = mutableListOf<Int>().apply {
        repeat(length) {
            this += readln().toInt()
        }
    }

    run(orderOfUse, 0, a, b, 0)

    if (results.isNotEmpty()) {
        println(results.min())
    } else {
        println(-1)
    }
}

private fun run(orderOfUse: List<Int>, index: Int, a: Int, b: Int, cnt: Int) {
    if (index == orderOfUse.size) {
        results += cnt
        return
    }
    val use = orderOfUse[index]
    val nextIndex = index + 1
    if (use in listOf(a, b)) {
        if (index == orderOfUse.size - 1) {
            results += cnt
        } else {
            run(orderOfUse, nextIndex, a, b, cnt)
        }
    } else {
        if (use < a) {
            val move = a - use
            run(orderOfUse, nextIndex, use, b, cnt + move)
        }
        if (use > b) {
            val move = use - b
            run(orderOfUse, nextIndex, a, use, cnt + move)
        }
        if (use in (a + 1) until b) {
            var move = use - a
            run(orderOfUse, nextIndex, use, b, cnt + move)

            move = b - use
            run(orderOfUse, nextIndex, a, use, cnt + move)
        }
    }
}

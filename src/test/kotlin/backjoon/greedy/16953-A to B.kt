package backjoon.greedy

fun main() {
    val (a, b) = readln().split(" ").map {
        it.toLong()
    }
    val deque = ArrayDeque<List<Long>>().apply {
        add(listOf(a, 1))
    }

    var result = -1L

    while (deque.isNotEmpty()) {
        val (n, c) = deque.removeFirst()

        if (n == b) {
            result = c
            break
        }

        val n1 = n * 2
        val n2 = "${n}1".toLong()
        val nc = c + 1

        if (n1 <= b) {
            deque.add(listOf(n1, nc))
        }
        if (n2 <= b) {
            deque.add(listOf(n2, nc))
        }
    }
    println(result)
}
package programmers.lv2.`전력망을 둘로 나누기`

import com.google.common.truth.Truth.assertThat
import kotlin.math.abs
import kotlin.math.min

fun main() {
    with(Solution()) {
        genTestCases().forEach { testCase ->
            assertThat(
                solution(
                    testCase.input.n,
                    testCase.input.wires,
                )
            ).isEqualTo(testCase.output)
        }
    }
}

private class TestCase(
    val input: Input,
    val output: Int,
) {
    class Input(
        val n: Int, val wires: Array<IntArray>
    )
}

private fun genTestCases(): List<TestCase> = mutableListOf<TestCase>().apply {
    add(
        TestCase(
            input = TestCase.Input(
                n = 9, wires = arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(4, 6),
                    intArrayOf(4, 7),
                    intArrayOf(7, 8),
                    intArrayOf(7, 9),
                )
            ), output = 3
        )
    )
    add(
        TestCase(
            input = TestCase.Input(
                n = 4, wires = arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                )
            ), output = 0
        )
    )
    add(
        TestCase(
            input = TestCase.Input(
                n = 7, wires = arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 7),
                    intArrayOf(3, 7),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(6, 7),
                )
            ), output = 1
        )
    )
}

class Solution {

    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE

        val graph = wires.toGraph(n + 1)

        wires.forEach { wire ->
            val (a, b) = wire

            graph[a].remove(b)
            graph[b].remove(a)

            val subGraph1Count = graph.nodeCount(
                start = a
            )
            val subGraph2Count = graph.nodeCount(
                start = b
            )

            answer = min(
                answer, abs(subGraph1Count - subGraph2Count)
            )

            graph[a].add(b)
            graph[b].add(a)
        }

        return answer
    }

    private fun Array<IntArray>.toGraph(n: Int) = Array(n) {
        mutableSetOf<Int>()
    }.also { graph ->
        this@toGraph.forEach {
            val (a, b) = it
            graph[a].add(b)
            graph[b].add(a)
        }
    }

    private fun Array<MutableSet<Int>>.nodeCount(start: Int): Int {
        var count = 0
        val queue = ArrayDeque<Int>().apply {
            add(start)
        }
        val visited = BooleanArray(size).apply {
            set(start, true)
        }
        while (queue.isNotEmpty()) {
            count++

            val node = queue.removeFirst()
            val connectedNodes = this[node]

            for (connectedNode in connectedNodes) {
                if (visited[connectedNode]) {
                    continue
                }
                visited[connectedNode] = true
                queue.add(connectedNode)
            }
        }
        return count
    }
}
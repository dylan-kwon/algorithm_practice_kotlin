package programmers.lv3.`이중 우선 순위 큐`

import com.google.common.truth.Truth.assertThat
import java.util.*

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                arrayOf(
                    "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"
                ),
            )
        ).isEqualTo(intArrayOf(0, 0))

        assertThat(
            solution(
                arrayOf(
                    "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
                ),
            )
        ).isEqualTo(intArrayOf(333, -45))
    }
}

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        operations.map(::mapOperation).forEach { operation ->
            when (operation) {
                is Operation.I -> {
                    minHeap.offer(operation.value)
                    maxHeap.offer(operation.value)
                }

                is Operation.DMin -> {
                    val value = minHeap.poll()
                    maxHeap.remove(value)
                }

                is Operation.DMax -> {
                    val value = maxHeap.poll()
                    minHeap.remove(value)
                }
            }
        }

        return intArrayOf(
            maxHeap.poll() ?: 0,
            minHeap.poll() ?: 0,
        )
    }

    private sealed interface Operation {
        data class I(val value: Int) : Operation
        data object DMax : Operation
        data object DMin : Operation
    }

    private fun mapOperation(strOperation: String): Operation {
        val (command, value) = strOperation.split(" ")
        return when (command) {
            "I" -> Operation.I(value.toInt())
            "D" -> when (value) {
                "1" -> Operation.DMax
                "-1" -> Operation.DMin
                else -> throw Exception()
            }

            else -> throw Exception()
        }
    }
}
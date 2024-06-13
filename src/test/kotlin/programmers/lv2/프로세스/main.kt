package programmers.lv2.`프로세스`

import com.google.common.truth.Truth.assertThat

fun main() {

    with(Solution()) {
        assertThat(
            solution(
                intArrayOf(2, 1, 3, 2), 2
            )
        ).isEqualTo(1)

        assertThat(
            solution(
                intArrayOf(1, 1, 9, 1, 1, 1), 0
            )
        ).isEqualTo(5)
    }
}

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        val queue = ArrayDeque(
            priorities.withIndex().toList()
        )
        while (queue.isNotEmpty()) {
            val process = queue.removeFirst()
            val hasHigher = queue.find {
                it.value > process.value
            } != null

            if (hasHigher) {
                queue.addLast(process)
            } else {
                answer++
                if (process.index == location) {
                    break
                }
            }
        }
        return answer
    }
}

package programmers.lv1.`K번째 수`

import com.google.common.truth.Truth.assertThat

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(
                    intArrayOf(2, 5, 3),
                    intArrayOf(4, 4, 1),
                    intArrayOf(1, 7, 3),
                )
            )
        ).isEqualTo(intArrayOf(5, 6, 3))
    }
}

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()

        commands.forEach { command ->
            val (i, j, k) = command
            val sorted = array.slice(i - 1 until j).sorted()
            answer.add(sorted[k - 1])
        }

        return answer.toIntArray()
    }
}
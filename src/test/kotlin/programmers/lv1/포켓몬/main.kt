package programmers.lv1.포켓몬

import com.google.common.truth.Truth.assertThat
import kotlin.math.min

fun main() {
    with(Solution()) {
        assertThat(solution(intArrayOf(3, 1, 2, 3)))
            .isEqualTo(2)

        assertThat(solution(intArrayOf(3, 3, 3, 2, 2, 4)))
            .isEqualTo(3)

        assertThat(solution(intArrayOf(3, 3, 3, 2, 2, 2)))
            .isEqualTo(2)
    }
}

internal class Solution {
    fun solution(numbers: IntArray): Int {
        val maxCount = numbers.size / 2
        val typeCount = numbers.toSet().size
        return min(maxCount, typeCount)
    }
}
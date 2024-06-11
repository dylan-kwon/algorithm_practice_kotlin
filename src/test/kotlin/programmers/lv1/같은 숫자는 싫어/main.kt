package programmers.lv1.`같은 숫자는 싫어`

import com.google.common.truth.Truth.assertThat

fun main() {
    with(Solution()) {
        assertThat(solution(intArrayOf(1, 1, 3, 3, 0, 1, 1)))
            .isEqualTo(intArrayOf(1, 3, 0, 1))

        assertThat(solution(intArrayOf(4, 4, 4, 3, 3)))
            .isEqualTo(intArrayOf(4, 3))
    }
}

class Solution {
    fun solution(aar: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (e in aar) {
            if (e == result.lastOrNull()) {
                continue
            }
            result.add(e)
        }
        return result.toIntArray()
    }
}
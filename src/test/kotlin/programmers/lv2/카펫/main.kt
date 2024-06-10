package programmers.lv2.카펫

import com.google.common.truth.Truth.assertThat

fun main() {
    Solution().apply {
        assertThat(solution(10, 2))
            .isEqualTo(intArrayOf(4, 3))

        assertThat(solution(8, 1))
            .isEqualTo(intArrayOf(3, 3))

        assertThat(solution(24, 24))
            .isEqualTo(intArrayOf(8, 6))

    }
}

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val answer = intArrayOf(0, 0)
        var line = 0

        while (line < yellow) {
            line++
            if (yellow % line != 0) {
                continue
            }
            if ((((yellow / line) + 2) * 2) + (line * 2) == brown) {
                answer[0] = (yellow / line) + 2
                answer[1] = line + 2
                break
            }
        }
        return answer
    }
}

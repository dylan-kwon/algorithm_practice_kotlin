package programmers.lv2.`H-Index`

import com.google.common.truth.Truth.assertThat
import kotlin.math.max


fun main() {
    with(Solution()) {
        assertThat(
            solution(
                intArrayOf(3, 0, 6, 1, 5)
            )
        ).isEqualTo(3)

        assertThat(
            solution(
                intArrayOf(2, 5, 7, 8, 9).apply { shuffle() }
            )
        ).isEqualTo(4)


        assertThat(
            solution(
                intArrayOf(2, 5, 7, 8, 9, 10, 20).apply { shuffle() }
            )
        ).isEqualTo(5)
    }
}

class Solution {
    fun solution(citations: IntArray): Int {
        var result = 0
        for ((i, e) in citations.sorted().withIndex()) {
            if (e <= citations.size - i) {
                result = e
                continue
            } else {
                result = max(result, citations.size - i)
                break
            }
        }
        return result
    }
}
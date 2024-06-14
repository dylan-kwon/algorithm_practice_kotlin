package programmers.lv2.`더 맵게`

import com.google.common.truth.Truth.assertThat
import java.util.*

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                intArrayOf(1, 2, 3, 9, 10, 12), 7
            )
        ).isEqualTo(2)
    }
}

class Solution {
    fun solution(scoville: IntArray, k: Int): Int {
        var answer = 0
        val queue = PriorityQueue(scoville.toList())
        while (queue.isNotEmpty()) {
            val minFood1 = queue.poll()
            if (minFood1 >= k) {
                break
            }
            if (queue.isEmpty()) {
                answer = -1
                break
            }
            val minFood2 = queue.poll()
            val newFood = minFood1 + (minFood2 * 2)

            queue.add(newFood)

            answer++
        }
        return answer
    }
}

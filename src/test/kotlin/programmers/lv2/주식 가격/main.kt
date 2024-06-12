package programmers.lv2.`주식 가격`

import com.google.common.truth.Truth.assertThat

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                intArrayOf(1, 2, 3, 2, 3),
            )
        ).isEqualTo(intArrayOf(4, 3, 1, 1, 0))
    }
}

class Solution {

    fun solution(prices: IntArray): IntArray {
        val answer = IntArray(prices.size) {
            prices.size - 1 - it
        }
        val stack = ArrayDeque<Int>(0)
        for ((i, price) in prices.withIndex()) {
            while (stack.isNotEmpty() && price < prices[stack.last()]) {
                val last = stack.removeLast()
                answer[last] = i - last
            }
            stack.addLast(i)
        }
        return answer
    }

}

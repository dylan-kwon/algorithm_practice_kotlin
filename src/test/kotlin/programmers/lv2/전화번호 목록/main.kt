package programmers.lv2.`전화번호 목록`

import com.google.common.truth.Truth.assertThat

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                arrayOf("119", "97674223", "1195524421"),
            )
        ).isEqualTo(false)

        assertThat(
            solution(
                arrayOf("123", "456", "789"),
            )
        ).isEqualTo(true)


        assertThat(
            solution(
                arrayOf("12", "123", "1235", "567", "88"),
            )
        ).isEqualTo(false)
    }
}


class Solution {
    /**
     * 1. 숫자를 정렬한다.
     * 2. 순차 탐색하여 현재 인덱스의 값과 다음 인덱스의 값을 꺼낸다.
     * 3. 다음 값이 현재 값으로 시작하면 False를 반환한다.
     */
    fun solution(phoneBook: Array<String>): Boolean {
        val sorted = phoneBook.sorted()
        for (i in 0 until sorted.size - 1) {
            val current = sorted[i]
            val next = sorted[i + 1]

            if (next.startsWith(current)) {
                return false
            }
        }
        return true
    }
}
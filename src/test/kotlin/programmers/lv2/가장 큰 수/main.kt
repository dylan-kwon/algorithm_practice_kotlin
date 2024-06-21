package programmers.lv2.`가장 큰 수`

import com.google.common.truth.Truth.assertThat


fun main() {
    with(Solution()) {
        assertThat(
            solution(
                intArrayOf(6, 10, 2)
            )
        ).isEqualTo("6210")

        assertThat(
            solution(
                intArrayOf(3, 30, 34, 5, 9)
            )
        ).isEqualTo("9534330")

    }
}

class Solution {
    fun solution(numbers: IntArray): String = numbers
        .toList()
        .map {
            it.toString()
        }
        .sortedWith { o1, o2 ->
            -when {
                o1.length == o2.length -> o1.compareTo(o2)
                else -> (o1 + o2).compareTo(o2 + o1)
            }
        }.joinToString(
            separator = ""
        )
        .takeUnless {
            it.startsWith("0")
        } ?: "0"
}
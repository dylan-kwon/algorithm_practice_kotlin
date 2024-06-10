package programmers.lv2.`이진 변환 반복하기`

import com.google.common.truth.Truth.assertThat

fun main() {
    assertThat(
        solution("110010101001")
    ).isEqualTo(intArrayOf(3, 8))

    assertThat(
        solution("01110")
    ).isEqualTo(intArrayOf(3, 3))

    assertThat(
        solution("1111111")
    ).isEqualTo(intArrayOf(4, 1))
}


private fun solution(s: String): IntArray {
    var tempString = s

    var transformCnt = 0
    var removeZeroCnt = 0

    while (true) {
        val groupBy = tempString.groupBy { it }
        val zero = groupBy['0'] ?: listOf()
        val one = groupBy['1'] ?: listOf()

        transformCnt++
        removeZeroCnt += zero.size

        tempString = one.size.toString(2)

        if (tempString == "1") {
            break
        }
    }
    return intArrayOf(transformCnt, removeZeroCnt)
}

package programmers.lv2.`최댓값과 최솟값`

import com.google.common.truth.Truth.assertThat


fun main() {
    assertThat(solution("1 2 3 4"))
        .isEqualTo("1 4")

    assertThat(solution("-1 -2 -3 -4"))
        .isEqualTo("-4 -1")

    assertThat(solution("-1 -1"))
        .isEqualTo("-1 -1")
}

private fun solution(s: String): String {
    val list = s.split(" ").map {
        it.toInt()
    }.sorted()

    val min = list.first()
    val max = list.last()

    return "$min $max"
}

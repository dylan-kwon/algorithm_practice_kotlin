package programmers.lv2.`JadenCase 문자열 만들기`

import com.google.common.truth.Truth.assertThat


fun main() {
    assertThat(solution("3people unFollowed me"))
        .isEqualTo("3people Unfollowed Me")

    assertThat(solution("for the last week"))
        .isEqualTo("For The Last Week")
}

private fun solution(s: String): String {
    return s.split(" ").joinToString(separator = " ") {
        if (it.isEmpty()) {
            return@joinToString it
        }
        val first = it.first().uppercase()
        if (it.length == 1) {
            return@joinToString first
        }
        val others = it.substring(1).lowercase()
        "$first$others"
    }
}

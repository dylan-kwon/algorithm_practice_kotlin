package programmers.lv2.`피보나치 수`

import com.google.common.truth.Truth.assertThat

fun main() {
    assertThat(solution(0)).isEqualTo(0)
    assertThat(solution(1)).isEqualTo(1)
    assertThat(solution(2)).isEqualTo(1)
    assertThat(solution(3)).isEqualTo(2)
    assertThat(solution(4)).isEqualTo(3)
    assertThat(solution(5)).isEqualTo(5)
}

private fun solution(n: Int): Int {
    return fibonacci(n)
}

private fun fibonacci(n: Int): Int {
    if (n < 2) {
        return n
    }
    val fibonacci = IntArray(n + 1).apply {
        set(0, 0)
        set(1, 1)
    }

    for (i in 2..n) {
        fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567
    }
    return fibonacci[n]
}
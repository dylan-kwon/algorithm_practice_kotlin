package programmers.lv2.`올바른 괄호`

import com.google.common.truth.Truth.assertThat

fun main() {
    with(Solution()) {

        assertThat(solution("()()"))
            .isEqualTo(true)

        assertThat(solution("(())()"))
            .isEqualTo(true)

        assertThat(solution(")()("))
            .isEqualTo(false)

        assertThat(solution("(()("))
            .isEqualTo(false)

    }
}

class Solution {
    fun solution(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            when (c) {
                '(' -> {
                    stack.addLast(c)
                }

                ')' -> when (stack.lastOrNull()) {
                    null -> {
                        return false
                    }
                    '(' -> {
                        stack.removeLastOrNull()
                    }

                    ')' -> stack.addLast(c)
                }
            }
        }
        return stack.isEmpty()
    }
}

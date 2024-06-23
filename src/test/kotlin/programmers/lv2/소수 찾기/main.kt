package programmers.lv2.`소수 찾기`

import com.google.common.truth.Truth.assertThat
import java.util.*

fun main() {
    with(Solution()) {
        genTestCases().forEach { testCase ->
            assertThat(solution(testCase.input)).isEqualTo(testCase.output)
        }
    }
}

private class TestCase(
    val input: String,
    val output: Int,
)

private fun genTestCases(): List<TestCase> = mutableListOf<TestCase>().apply {
    add(
        TestCase(
            input = "17",
            output = 3
        )
    )
    add(
        TestCase(
            input = "011",
            output = 2
        )
    )
}


class Solution {

    companion object {
        private const val MAXIMUM_SIZE = 10_000_000
    }

    private val eratos = eratos()

    fun solution(numbers: String): Int {
        val permutation = permutation(
            numbers.toList()
        )
        return permutation.count(::isPrimeNumber)
    }

    private fun eratos(): BooleanArray {
        val eratos = BooleanArray(MAXIMUM_SIZE) {
            true
        }.apply {
            set(0, false)
            set(1, false)
        }
        for ((number, isPrime) in eratos.withIndex()) {
            if (!isPrime) {
                continue
            }
            try {
                for (i in (number * number) until eratos.size step number) {
                    eratos[i] = false
                }
            } catch (e: Exception) {
                continue
            }
        }
        return eratos
    }

    private fun permutation(numbers: List<Char>): Set<Int> {
        val result = mutableSetOf<Int>()

        val visited = BooleanArray(numbers.size)

        fun run(stack: Stack<Char>) {
            if (stack.isNotEmpty()) {
                result.add(
                    stack.joinToString(separator = "").toInt()
                )
            }
            for ((i, number) in numbers.withIndex()) {
                if (visited[i]) {
                    continue
                }
                visited[i] = true
                stack.push(number)

                run(stack)

                visited[i] = false
                stack.pop()
            }
        }
        run(Stack())

        return result
    }

    private fun isPrimeNumber(number: Int) = eratos[number]
}
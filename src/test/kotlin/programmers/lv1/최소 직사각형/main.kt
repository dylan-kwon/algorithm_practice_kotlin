package programmers.lv1.`최소 직사각형`

import com.google.common.truth.Truth.assertThat
import kotlin.math.max
import kotlin.math.min

fun main() {
    with(Solution()) {
        genTestCases().forEach { testCase ->
            assertThat(solution(testCase.input)).isEqualTo(testCase.output)
        }
    }
}

private class TestCase(
    val input: Array<IntArray>,
    val output: Int
)

private fun genTestCases(): List<TestCase> = mutableListOf<TestCase>().apply {
    this += genTestCase1()
    this += genTestCase2()
    this += genTestCase3()
}

private fun genTestCase1() = TestCase(
    input = arrayOf(
        intArrayOf(60, 50),
        intArrayOf(30, 70),
        intArrayOf(60, 30),
        intArrayOf(80, 40),
    ),
    output = 4000
)

private fun genTestCase2() = TestCase(
    input = arrayOf(
        intArrayOf(10, 7),
        intArrayOf(12, 3),
        intArrayOf(8, 15),
        intArrayOf(14, 7),
        intArrayOf(5, 15),
    ),
    output = 120
)

private fun genTestCase3() = TestCase(
    input = arrayOf(
        intArrayOf(14, 4),
        intArrayOf(19, 6),
        intArrayOf(6, 16),
        intArrayOf(18, 7),
        intArrayOf(7, 11),
    ),
    output = 133
)


class Solution {
    fun solution(sizes: Array<IntArray>): Int {

        var maxWidth = 0
        var maxHeight = 0

        sizes.forEach { size ->
            val (width, height) = size
            maxWidth = max(maxWidth, max(width, height))
            maxHeight = max(maxHeight, min(width, height))
        }

        return maxWidth * maxHeight
    }
}
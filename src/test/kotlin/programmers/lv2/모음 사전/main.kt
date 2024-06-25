package programmers.lv2.`모음 사전`

import com.google.common.truth.Truth.assertThat
import java.util.*

fun main() {
    with(Solution()) {
        genTestCases().forEach { testCase ->
            assertThat(
                solution(
                    testCase.input
                )
            ).isEqualTo(testCase.output)
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
            input = "AAAAE",
            output = 6
        )
    )
    add(
        TestCase(
            input = "AAAE",
            output = 10
        )
    )
    add(
        TestCase(
            input = "I",
            output = 1563
        )
    )
    add(
        TestCase(
            input = "EIO",
            output = 1189
        )
    )

}

class Solution {

    companion object {
        private val chars = charArrayOf('A', 'E', 'I', 'O', 'U')
        private const val maxLength = 5

        private val endWord = chars.last().toString().repeat(maxLength)
    }

    private var dictionary = initDictionary()

    private fun initDictionary(): Map<String, Int> {
        val dictionary = Hashtable<String, Int>()

        val stack = Stack<Char>()

        var index = 0
        while (true) {
            if (stack.size < maxLength) {
                stack.push(chars.first())
            } else {
                var last: Char
                while (true) {
                    last = stack.pop()
                    if (last != chars.last()) {
                        break
                    }
                }
                val nextIndex = (chars.indexOf(last) + 1) % chars.size
                stack.push(chars[nextIndex])
            }

            index++
            val string = stack.joinToString(separator = "")
            dictionary[string] = index

            if (string == endWord) {
                break
            }
        }

        return dictionary
    }

    fun solution(word: String): Int {
        return dictionary[word] ?: -1
    }
}
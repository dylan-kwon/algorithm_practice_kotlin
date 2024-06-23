package programmers.lv2.피로도

import com.google.common.truth.Truth.assertThat
import java.util.*
import kotlin.math.max

fun main() {
    with(Solution()) {
        genTestCases().forEach { testCase ->
            assertThat(
                solution(
                    testCase.input.k,
                    testCase.input.dungeons,
                )
            ).isEqualTo(testCase.output)
        }
    }
}

private class TestCase(
    val input: Input,
    val output: Int,
) {
    class Input(
        val k: Int,
        val dungeons: Array<IntArray>
    )
}

private fun genTestCases(): List<TestCase> = mutableListOf<TestCase>().apply {
    add(
        TestCase(
            input = TestCase.Input(
                k = 80,
                dungeons = arrayOf(
                    intArrayOf(80, 20),
                    intArrayOf(50, 40),
                    intArrayOf(30, 10),
                )
            ),
            output = 3
        )
    )
}

class Solution {
    data class Dungeon(
        val pre: Int,
        val post: Int
    )

    class DungeonPack(
        val dungeons: List<Dungeon>
    )

    fun solution(k: Int, dungeons: Array<IntArray>): Int = permutation(
        dungeons.map {
            Dungeon(
                it.first(), it.last()
            )
        }
    ).maxCount(k)

    private fun permutation(dungeons: List<Dungeon>): List<DungeonPack> {
        val result = mutableListOf<DungeonPack>()
        val visited = BooleanArray(dungeons.size)

        fun run(stack: Stack<Dungeon>) {
            if (stack.size == dungeons.size) {
                result.add(
                    DungeonPack(
                        dungeons = stack.toList()
                    )
                )
                return
            }
            for ((i, dungeon) in dungeons.withIndex()) {
                if (visited[i]) {
                    continue
                }
                visited[i] = true
                stack.push(dungeon)

                run(stack)

                visited[i] = false
                stack.pop()
            }
        }
        run(Stack())
        return result
    }

    private fun List<DungeonPack>.maxCount(k: Int): Int {
        var max = -1
        for (pack in this) {
            var tempK = k
            var count = 0
            for (dungeon in pack.dungeons) {
                val (pre, post) = dungeon
                if (tempK < pre) {
                    continue
                }
                count++
                tempK -= post
            }
            if (count > 0) {
                max = max(max, count)
            }
        }
        return max
    }
}
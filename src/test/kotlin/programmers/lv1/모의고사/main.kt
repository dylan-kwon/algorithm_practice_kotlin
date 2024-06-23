package programmers.lv1.모의고사

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
    val input: IntArray,
    val output: IntArray,
)

private fun genTestCases(): List<TestCase> = mutableListOf<TestCase>().apply {
    add(
        TestCase(
            input = intArrayOf(
                1, 2, 3, 4, 5
            ), output = intArrayOf(1)
        )
    )
    add(
        TestCase(
            input = intArrayOf(
                1, 3, 2, 4, 2
            ), output = intArrayOf(1, 2, 3)
        )
    )
}


class Solution {

    /**
     * 수포자
     */
    enum class Person(
        /**
         * 수포자 변호
         */
        val number: Int,

        /**
         * 찍는 방법
         */
        val how: List<Int>
    ) {
        SuPo1(
            number = 1,
            how = listOf(1, 2, 3, 4, 5),
        ),
        SuPo2(
            number = 2,
            how = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        ),
        SuPo3(
            number = 3,
            how = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )
    }

    /**
     * 시험 결과
     */
    data class TestResult(
        /**
         * 응시자
         */
        val person: Person,

        /**
         * 득점
         */
        val score: Int
    ) : Comparable<TestResult> {
        override fun compareTo(other: TestResult): Int {
            return -(score.compareTo(other.score))
        }
    }

    /**
     * 고득점자 수포자를 오름차순으로 반환
     */
    fun solution(answers: IntArray): IntArray {
        // 1. 전체 채점
        val testResults = runAllScoring(answers)

        // 2. 고득점자 추출
        val maxes = testResults.maxes()

        // 3. 수포자 번호 매핑 및 오름차순 정렬
        val answer = maxes.map {
            it.person.number
        }.sorted()

        // 4. 반환
        return answer.toIntArray()
    }

    /**
     * @param answers 실제 정답
     * @param 수포자별 채점 결과를 리스트로 반환
     */
    private fun runAllScoring(answers: IntArray): List<TestResult> {
        val testMap = initTestMap()
        for (person in Person.entries) {
            testMap[person] = person.runScoring(answers)
        }
        return testMap.entries.map { test ->
            TestResult(
                person = test.key, score = test.value
            )
        }
    }

    /**
     * @param <수포자 : 점수> 맵 초기화
     */
    private fun initTestMap() = mutableMapOf<Person, Int>().apply {
        Person.entries.forEach { person ->
            this += person to 0
        }
    }

    /**
     * @param 개별 채점 결과 리턴
     */
    private fun Person.runScoring(answers: IntArray): Int {
        var score = 0
        answers.forEachIndexed { i, answer ->
            val isAnswer = isAnswer(
                expect = how[i % how.size], actual = answer
            )
            if (isAnswer) {
                score++
            }
        }
        return score
    }

    /**
     * @param expect 찍은 답
     * @param actual 실제 정답
     * @return 정답 여부
     */
    private fun isAnswer(expect: Int, actual: Int) = expect == actual

    /**
     * @return 고득점자 리턴 (동점인 경우 리스트에 모두 포함)
     */
    private fun List<TestResult>.maxes(): List<TestResult> {
        val result = mutableListOf<TestResult>()
        val tests = PriorityQueue(this)

        var maxScore = 0

        while (tests.isNotEmpty()) {
            val test = tests.poll()
            if (test.score < maxScore) {
                break
            }
            result.add(test)
            maxScore = test.score
        }
        return result
    }
}
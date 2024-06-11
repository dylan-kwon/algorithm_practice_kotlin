package programmers.lv2.`기능 개발`

import com.google.common.truth.Truth.assertThat
import kotlin.math.ceil

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                intArrayOf(93, 30, 55),
                intArrayOf(1, 30, 5),
            )
        ).isEqualTo(intArrayOf(2, 1))

        assertThat(
            solution(
                intArrayOf(95, 90, 99, 99, 80, 99),
                intArrayOf(1, 1, 1, 1, 1, 1),
            )
        ).isEqualTo(intArrayOf(1, 3, 2))
    }
}

class Solution {

    fun solution(
        progresses: IntArray,
        speeds: IntArray
    ): IntArray {
        val answer = calcAnswer(
            mapData(progresses, speeds)
        )
        return answer.toIntArray()
    }

    private data class Data(
        val progress: Int,
        val speed: Int,
        val completionDay: Int
    )

    /**
     * 데이터 매핑 및 작업 소요일 계산
     */
    private fun mapData(
        progresses: IntArray,
        speeds: IntArray
    ) = progresses.indices.map {
        val progress = progresses[it]
        val speed = speeds[it]
        val completionDay = ceil(
            (100 - progress) / speed.toFloat()
        )
        Data(
            progress = progress,
            speed = speed,
            completionDay = completionDay.toInt()
        )
    }

    /**
     * 정답 계산
     * 1. 배포는 순서대로
     * 2. 앞 인덱스의 작업이 완료되면 같이 배포
     */
    private fun calcAnswer(dataList: List<Data>): List<Int> {
        val answer = mutableListOf<Int>()

        var tempIndex = 0
        var tempDay = dataList.first().completionDay

        dataList.forEachIndexed { index, data ->
            if (tempDay < data.completionDay) {
                answer.add(index - tempIndex)

                tempIndex = index
                tempDay = data.completionDay
            }
        }
        answer.add(
            dataList.size - tempIndex
        )
        return answer
    }
}

package programmers.lv3.`디스크 컨트롤러`

import com.google.common.truth.Truth.assertThat
import java.util.*

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(1, 9),
                    intArrayOf(2, 6),
                ),
            )
        ).isEqualTo(9)
    }
}

class Solution {
    private data class Job(
        val start: Int,
        val duration: Int
    )

    /**
     * 1. 빨리 시작하는 작업 우선
     * 2. 짧게 끝나는 작업 우선
     */
    fun solution(jobs: Array<IntArray>): Int {
        val startQueue = jobs.map {
            Job(
                start = it.first(),
                duration = it.last(),
            )
        }.let {
            PriorityQueue(compareBy<Job> {
                it.start
            }).apply {
                addAll(it)
            }
        }

        var jobEndTime = 0  // 마지막 작업이 끝난 시간
        var answer = 0      // jobEndTime + 대기 시간

        while (startQueue.isNotEmpty()) {
            val durationQueue = PriorityQueue<Job>(
                compareBy {
                    it.duration
                }
            )
            while (startQueue.isNotEmpty()) {
                if (startQueue.peek().start > jobEndTime) {
                    break
                }
                durationQueue.offer(startQueue.poll())
            }
            if (durationQueue.isEmpty()) {
                jobEndTime++
                continue
            }
            val job = durationQueue.poll()

            // 작업 종료 시간 누적
            jobEndTime += job.duration

            // 작업 종료 시간 - 작업 시작 시간 = 작업 소요 시간
            answer += jobEndTime - job.start

            while (durationQueue.isNotEmpty()) {
                startQueue.offer(durationQueue.poll())
            }
        }

        return answer / jobs.size
    }
}
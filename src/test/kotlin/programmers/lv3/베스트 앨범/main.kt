package programmers.lv3.`베스트 앨범`

import com.google.common.truth.Truth.assertThat
import java.util.*

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                arrayOf("classic", "pop", "classic", "classic", "pop"),
                intArrayOf(500, 600, 150, 800, 2500),
            )
        ).isEqualTo(intArrayOf(4, 1, 3, 0))
    }
}

private data class Song(
    val id: Int,
    val genre: String,
    val play: Int
)

/**
 * 1. 각 장르 별로 2곡씩 수록
 * 2. 많이 재생된 장르 먼저
 * 3. 장르 내에서 재생이 많은 노래 먼저
 * 4. 같다면 고유 번호가 낮은 노래 먼저
 */
class Solution {
    fun solution(
        genres: Array<String>, plays: IntArray
    ): IntArray {
        val answer = mutableListOf<Int>()

        val table = createTable(genres, plays)
        val sums = table.mapValues {
            it.value.sumOf { it.play }
        }.toList()
            .sortedByDescending { it.second }

        for (sum in sums) {
            var cnt = 0
            val queue = table[sum.first]!!
            while (queue.isNotEmpty() && cnt < 2) {
                answer.add(
                    queue.poll().id
                )
                cnt++
            }
            table[sum.first]
        }
        return answer.toIntArray()
    }

    private fun createTable(
        genres: Array<String>, plays: IntArray
    ) = mutableMapOf<String, PriorityQueue<Song>>().apply {
        for (i in genres.indices) {
            val genre = genres[i]
            val play = plays[i]

            getOrPut(genre) {
                PriorityQueue(
                    compareBy<Song> {
                        -it.play
                    }.thenBy {
                        it.id
                    }
                )
            }.add(Song(i, genre, play))
        }
    }
}
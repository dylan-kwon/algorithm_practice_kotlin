package programmers.lv1.`완주하지 못한 선수`

import com.google.common.truth.Truth.assertThat


fun main() {
    with(Solution()) {
        assertThat(
            solution(
                arrayOf("leo", "kiki", "eden"),
                arrayOf("eden", "kiki")
            )
        ).isEqualTo("leo")

        assertThat(
            solution(
                arrayOf("marina", "josipa", "nikola", "vinko", "filipa"),
                arrayOf("josipa", "filipa", "marina", "nikola")
            )
        ).isEqualTo("vinko")

        assertThat(
            solution(
                arrayOf("mislav", "stanko", "mislav", "ana"),
                arrayOf("stanko", "ana", "mislav")
            )
        )
            .isEqualTo("mislav")
    }
}

private class Solution {
    fun solution(
        participant: Array<String>,
        completion: Array<String>
    ): String {
        val map = mutableMapOf<String, Int>()

        for (name in participant) {
            map[name] = map.getOrDefault(name, 0) + 1
        }
        for (name in completion) {
            map[name] = map.getOrDefault(name, 0) - 1
            if (map[name] == 0) {
                map.remove(name)
            }
        }
        return map.keys.first()
    }
}
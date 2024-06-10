package programmers.lv2.의상

import com.google.common.truth.Truth.assertThat

fun main() {
    with(Solution()) {
        assertThat(
            solution(
                arrayOf(
                    arrayOf("yellow_hat", "headgear"),
                    arrayOf("blue_sunglasses", "eyewear"),
                    arrayOf("green_turban", "headgear"),
                )
            )
        ).isEqualTo(5)

        assertThat(
            solution(
                arrayOf(
                    arrayOf("crow_mask", "face"),
                    arrayOf("blue_sunglasses", "face"),
                    arrayOf("smoky_makeup", "face"),
                )
            )
        ).isEqualTo(3)

    }
}


class Solution {
    /**
     * 1. 의상 종류별로 그룹핑
     * 2. 착용하지 않아도 되므로 의상 종류별로 한 가지 경우의 수 추가
     * 3. 적어도 한 종류는 착용해야 하므로 전체를 착용하지 않는 경우의 수 감소
     */
    fun solution(clothes: Array<Array<String>>): Int {
        return clothes.groupBy {
            it.last()
        }.map {
            it.value.size + 1
        }.reduce { acc, size ->
            acc * size
        } - 1
    }
}
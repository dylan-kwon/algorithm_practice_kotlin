package backjoon.greedy

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (x, y, w, s) = readln().split(" ").map {
        it.toLong()
    }

    val result: Long

    val max = max(x, y)
    val min = min(x, y)

    if (w > s) {
        // 직선 1번보다 대각선이 저렴
        result = if ((x + y) % 2 == 0L) {
            max * s
        } else {
            if (max - min == 1L) {
                (min * s) + w
            } else {
                (min * s) + ((max - min - 1) * s) + w
            }
        }
    } else if (w * 2 > s) {
        // 직선 2번보다 대각선이 저렴
        val a = min * s
        val b = (max - min) * w
        result = a + b

    } else {
        // 직선으로만 이동이 저렴
        val a = x * w
        val b = y * w
        result = a + b
    }

    println(result)
}
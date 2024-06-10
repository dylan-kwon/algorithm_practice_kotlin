package backjoon.greedy

import kotlin.math.min

fun main() {
    val s = readln()

    var zeroToOne = 0
    var oneToZero = 0

    var current = ' '

    for (c in s) {
        if (c == current) {
            continue
        }
        if (c == '0') {
            oneToZero++
        } else {
            zeroToOne++
        }
        current = c
    }

    val result = min(zeroToOne, oneToZero)

    print(result)

}

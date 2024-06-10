package programmers.lv1.체육복

fun main() {
    solution(
        5,
        intArrayOf(2, 4),
        intArrayOf(1, 3, 5),
    ).let {
        println(it)
    }

    solution(
        5,
        intArrayOf(2, 4),
        intArrayOf(3),
    ).let {
        println(it)
    }

    solution(
        3,
        intArrayOf(3),
        intArrayOf(1),
    ).let {
        println(it)
    }
}

private fun solution(
    n: Int, lost: IntArray,
    reserve: IntArray
): Int {
    var answer = n

    val newLost = lost.toList().sorted() - reserve.toSet()
    val newReserve = (reserve.toSet() - lost.toSet()).toMutableSet()

    for (e in newLost) {
        if (newReserve.contains(e - 1)) {
            newReserve.remove(e - 1)
            continue
        }
        if (newReserve.contains(e + 1)) {
            newReserve.remove(e + 1)
            continue
        }
        answer--
    }

    return answer
}
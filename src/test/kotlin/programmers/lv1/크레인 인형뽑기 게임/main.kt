package programmers.lv1.`크레인 인형뽑기 게임`

fun main() {
    solution(
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 3),
            intArrayOf(0, 2, 5, 0, 1),
            intArrayOf(4, 2, 4, 4, 2),
            intArrayOf(3, 5, 1, 3, 1),
        ),
        intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    ).let {
        println(it)
    }
}

private fun solution(board: Array<IntArray>, moves: IntArray): Int {
    var result = 0

    val bucket = ArrayDeque<Int>()

    moves.forEach {
        val columnIndex = it - 1
        for (column in board) {
            if (column[columnIndex] == 0) {
                continue
            }
            val drawDoll = column[columnIndex]
            val lastDrawDoll = bucket.lastOrNull()

            if (lastDrawDoll == drawDoll) {
                bucket.removeLast()
                result += 2
            } else {
                bucket.addLast(drawDoll)
            }
            column[columnIndex] = 0
            break
        }
    }
    return result
}
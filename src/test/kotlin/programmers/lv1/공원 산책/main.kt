package programmers.lv1.`공원 산책`

fun main() {
    solution(
        arrayOf("SOO", "OOO", "OOO"),
        arrayOf("E 2", "S 2", "W 1"),
    ).let {
        println(it.joinToString())
    }
    solution(
        arrayOf("SOO", "OXX", "OOO"),
        arrayOf("E 2", "S 2", "W 1"),
    ).let {
        println(it.joinToString())
    }
    solution(
        arrayOf("OSO", "OOO", "OXO", "OOO"),
        arrayOf("E 2", "S 3", "W 1"),
    ).let {
        println(it.joinToString())
    }
}

private fun solution(park: Array<String>, routes: Array<String>): IntArray {
    val width = park.first().length
    val height = park.size

    var (i, j) = findStartPosition(park)

    routes.forEach {
        val command = it.split(" ")
        val direction = command.first()
        val distance = command.last().toInt()

        val newPosition = newPosition(
            park, i, j, width, height, direction, distance
        )
        if (newPosition != null) {
            i = newPosition.first()
            j = newPosition.last()
        }
    }

    return intArrayOf(i, j)
}

private fun findStartPosition(park: Array<String>): IntArray {
    var startPosition: IntArray? = null
    for ((i, row) in park.withIndex()) {
        for ((j, column) in row.withIndex()) {
            if (column == 'S') {
                startPosition = intArrayOf(i, j)
                break
            }
        }
        if (startPosition != null) {
            break
        }
    }
    return startPosition!!
}

private fun newPosition(
    park: Array<String>,
    currentI: Int,
    currentJ: Int,
    width: Int,
    height: Int,
    direction: String,
    distance: Int
): IntArray? {
    var newI = currentI
    var newJ = currentJ

    for (i in 0 until distance) {
        when (direction) {
            "E" -> {
                newJ += 1
            }

            "W" -> {
                newJ -= 1
            }

            "N" -> {
                newI -= 1
            }

            "S" -> {
                newI += 1
            }
        }
        if (!isValid(park, width, height, newI, newJ)) {
            return null
        }
    }
    return intArrayOf(newI, newJ)
}

fun isValid(
    park: Array<String>,
    width: Int,
    height: Int,
    i: Int,
    j: Int
): Boolean {
    if (i < 0 || i >= height) {
        return false
    }
    if (j < 0 || j >= width) {
        return false
    }
    if (park[i][j] == 'X') {
        return false
    }
    return true
}
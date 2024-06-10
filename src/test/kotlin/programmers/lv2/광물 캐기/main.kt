package programmers.lv2.`광물 캐기`

fun main() {
//    solution(
//        intArrayOf(1, 3, 2),
//        arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"),
//    ).let {
//        println(it)
//    }

    solution(
        intArrayOf(0, 1, 1),
        arrayOf(
            "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"
        ),
    ).let {
        println(it)
    }
}

val map = mapOf(
    "diamond" to 0,
    "iron" to 1,
    "stone" to 2,
)

private fun solution(picks: IntArray, minerals: Array<String>): Int {
    val parts = minerals.toList().run {
        val max = picks.sum() * 5
        if (size > max) {
            this.subList(0, max)
        } else {
            this
        }
    }.chunked(5).map {
        intArrayOf(0, 0, 0).apply {
            it.forEach { e ->
                this[map[e]!!] += 1
            }
        }
    }.sortedWith(
        compareBy({
            -it[0]
        }, {
            -it[1]
        }, {
            -it[2]
        })
    )

    var result = 0

    for (part in parts) {
        when {
            picks[0] > 0 -> {
                picks[0]--
                result += (part[0] * 1) + (part[1] * 1) + (part[2] * 1)
            }

            picks[1] > 0 -> {
                picks[1]--
                result += (part[0] * 5) + (part[1] * 1) + (part[2] * 1)
            }

            else -> {
                picks[2]--
                result += (part[0] * 25) + (part[1] * 5) + (part[2] * 1)
            }
        }
    }
    return result
}


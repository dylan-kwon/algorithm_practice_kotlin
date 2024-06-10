package programmers.lv1.`대충 만든 자판`

import java.util.*

fun main() {
    solution(
        arrayOf("ABACD", "BCEFD"),
        arrayOf("ABCD", "AABB"),
    ).let {
        println(it.joinToString())
    }

    solution(
        arrayOf("AA"),
        arrayOf("B"),
    ).let {
        println(it.joinToString())
    }

    solution(
        arrayOf("AGZ", "BSSS"),
        arrayOf("ASA", "BGZ"),
    ).let {
        println(it.joinToString())
    }
}

private fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
    val keyCountMap = Hashtable<Char, Int>()
    keymap.forEach {
        it.forEachIndexed { index, c ->
            val newCount = index + 1
            val oldCount = keyCountMap[c]
            if (oldCount == null) {
                keyCountMap[c] = newCount
            } else if (newCount < oldCount) {
                keyCountMap[c] = newCount
            }
        }
    }
    val answer = ArrayList<Int>()
    for (target in targets) {
        var possable = true
        var inputCount = 0
        for (c in target) {
            val needCount = keyCountMap[c]
            if (needCount == null) {
                possable = false
                break
            } else {
                inputCount += needCount
            }
        }
        if (possable) {
            answer.add(inputCount)
        } else {
            answer.add(-1)
        }
    }
    return answer.toIntArray()
}
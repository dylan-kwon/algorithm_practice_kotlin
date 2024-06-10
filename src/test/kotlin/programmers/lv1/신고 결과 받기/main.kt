package programmers.lv1.`신고 결과 받기`

import java.util.*

fun main() {
    solution(
        arrayOf("muzi", "frodo", "apeach", "neo"),
        arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
        2
    ).let {
        println(it.joinToString())
    }

    solution(
        arrayOf("con", "ryan"),
        arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
        3
    ).let {
        println(it.joinToString())
    }
}

private fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val reportMap = Hashtable<String, MutableSet<String>>()
    id_list.forEach {
        reportMap += it to mutableSetOf()
    }

    report.forEach {
        val (from, to) = it.split(" ")
        reportMap[to]!!.add(from)
    }

    val filtered = reportMap.filter {
        it.value.size >= k
    }

    val countMap = filtered.values.flatMap {
        it.toList()
    }.groupBy { it }

    val answer = mutableListOf<Int>()
    for (id in id_list) {
        val count = countMap[id]?.size ?: 0
        answer.add(count)
    }
    return answer.toIntArray()
}
package programmers.lv1.`개인정보 수집 유효기간`

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {
    solution(
        "2022.05.19",
        arrayOf("A 6", "B 12", "C 3"),
        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    ).let {
        println(it.joinToString())
    }

    solution(
        "2020.01.01",
        arrayOf("Z 3", "D 5"),
        arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
    ).let {
        println(it.joinToString())
    }
}

private fun solution(
    today: String,
    terms: Array<String>,
    privacies: Array<String>
): IntArray {
    var answer = TreeSet<Int>()
    val termsMap = Hashtable<String, Long>()

    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    val todayDate = LocalDate.parse(today, dateTimeFormatter)

    terms.forEach {
        val term = it.split(" ")
        val type = term.first()
        val month = term.last().toLong()
        termsMap += type to month
    }

    privacies.forEachIndexed { index, s ->
        val privacie = s.split(" ")
        val collectedDate = privacie.first()
        val termType = privacie.last()
        val month = termsMap[termType] ?: 0
        val expiredDate = LocalDate.parse(collectedDate, dateTimeFormatter).run {
            plusMonths(month)
        }

        if (!expiredDate.isAfter(todayDate)) {
            answer.add(index + 1)
        }
    }

    return answer.toIntArray()
}
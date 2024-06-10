package programmers.lv1.`달리기 경주`

fun main() {
    val result = solution(
        arrayOf("mumu", "soe", "poe", "kai", "mine"),
        arrayOf("kai", "kai", "mine", "mine")
    )
    println(result.joinToString())
}

private fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    val indexMap = LinkedHashMap<String, Int>()
    players.forEachIndexed { index, player ->
        indexMap += player to index
    }
    callings.forEach { player ->
        val playerIndex = indexMap[player]!!
        val targetIndex = playerIndex - 1
        val target = players[targetIndex]

        indexMap[player] = targetIndex
        indexMap[target] = playerIndex

        players[targetIndex] = player
        players[playerIndex] = target

    }
    return players
}
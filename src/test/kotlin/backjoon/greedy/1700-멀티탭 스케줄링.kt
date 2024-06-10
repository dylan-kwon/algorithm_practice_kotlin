package backjoon.greedy

import kotlin.math.max

fun main() {
    val (n, k) = readln().split(" ").map {
        it.toInt()
    }
    val orders = readln().split(" ").map {
        it.toInt()
    }
    val multitap = mutableSetOf<Int>()
    var result = 0

    loop@ for (i in 0 until k) {
        val newPlug = orders[i]

        if (multitap.size < n) {
            multitap.add(newPlug)
            continue
        }

        if (newPlug in multitap) {
            continue
        }

        val future = orders.subList(i + 1, k)
        val minus = multitap.minus(future.toSet())

        val out = if (minus.isEmpty()) {
            var index = 0
            for (plug in multitap) {
                index = max(index, future.indexOf(plug))
            }
            future[index]
        } else {
            minus.first()
        }

        multitap.remove(out)
        multitap.add(newPlug)
        result++
    }
    println(result)
}

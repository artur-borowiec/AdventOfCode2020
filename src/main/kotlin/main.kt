import java.io.File

const val SUM = 2020
const val FILE = "src/main/resources/input1.txt"
val CURRENT_TASK = Task.DAY1PART2

fun main() {
    printSolution()
}

fun printSolution() {
    println(
        "${CURRENT_TASK.name} ${when (CURRENT_TASK) {
            Task.DAY1PART1 -> getSolution11()
            Task.DAY1PART2 -> getSolution12()
        }}"
    )
}

fun getSolution11(): Int {
    val data = getData()
    data.forEach {
        if (data.contains(SUM - it))
            return (SUM - it) * it
    }

    return -1
}

fun getSolution12(): Int {
    val data = getData()
    data.forEachIndexed { i1, el1 ->
        data.forEachIndexed { i2, el2 ->
            if (i2 > i1) {
                if (data.contains(SUM - (el1 + el2)))
                    return el1 * el2 * (SUM-el1-el2)
            }
        }
    }

    return -1
}

private fun getData(): List<Int> {
    val data = mutableListOf<Int>()
    File(FILE).forEachLine {
        data.add(it.toInt())
    }
    return data
}

enum class Task {
    DAY1PART1, DAY1PART2
}
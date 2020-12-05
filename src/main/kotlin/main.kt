const val SUM = 2020
val CURRENT_TASK = Task.DAY4PART1

fun main() {
    printSolution()
}

fun printSolution() {
    println(
        "${CURRENT_TASK.name} ${when (CURRENT_TASK) {
            Task.DAY1PART1 -> getSolution11()
            Task.DAY1PART2 -> getSolution12()
            Task.DAY2PART1 -> getSolution21()
            Task.DAY2PART2 -> getSolution22()
            Task.DAY3PART1 -> getSolution31()
            Task.DAY3PART2 -> getSolution32()
            Task.DAY4PART1 -> getSolution41()
            Task.DAY4PART2 -> getSolution42()
        }}"
    )
}

enum class Task {
    DAY1PART1, DAY1PART2,
    DAY2PART1, DAY2PART2,
    DAY3PART1, DAY3PART2,
    DAY4PART1, DAY4PART2
}
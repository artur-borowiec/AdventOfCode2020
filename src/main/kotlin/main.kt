val CURRENT_TASK = Task.DAY8PART2

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
            Task.DAY5PART1 -> getSolution51()
            Task.DAY5PART2 -> getSolution52()
            Task.DAY6PART1 -> getSolution61()
            Task.DAY6PART2 -> getSolution62()
            Task.DAY7PART1 -> getSolution71()
            Task.DAY7PART2 -> getSolution72()
            Task.DAY8PART1 -> getSolution81()
            Task.DAY8PART2 -> getSolution82()
        }}"
    )
}

enum class Task {
    DAY1PART1, DAY1PART2,
    DAY2PART1, DAY2PART2,
    DAY3PART1, DAY3PART2,
    DAY4PART1, DAY4PART2,
    DAY5PART1, DAY5PART2,
    DAY6PART1, DAY6PART2,
    DAY7PART1, DAY7PART2,
    DAY8PART1, DAY8PART2
}
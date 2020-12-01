import java.io.File

const val SUM = 2020
const val FILE = "src/main/resources/input1.txt"

fun main(args: Array<String>) {
    println("TASK: 1  SOLUTION: ${getSolution()}")
}

fun getSolution(): Int {
    val data = mutableListOf<Int>()
    File(FILE).forEachLine {
        data.add(it.toInt())
    }

    data.forEach {
        if (data.contains(SUM - it))
            return (SUM-it) * it
    }

    return -1
}
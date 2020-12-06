import java.io.File

const val DAY1_INPUT = "src/main/resources/input1.txt"
const val DAY2_INPUT = "src/main/resources/input2.txt"
const val DAY3_INPUT = "src/main/resources/input3"
const val DAY4_INPUT = "src/main/resources/input4"
const val DAY5_INPUT = "src/main/resources/input5"
const val DAY6_INPUT = "src/main/resources/input6"

fun getDataForDay1(): List<Int> {
    val data = mutableListOf<Int>()
    File(DAY1_INPUT).forEachLine {
        data.add(it.toInt())
    }

    return data
}

fun getDataForDay2(): List<Password> {
    val data = mutableListOf<Password>()
    File(DAY2_INPUT).forEachLine {
        val split = it.split(" ")
        val rangeSplit = split[0].split("-")
        val char = split[1][0]
        data.add(Password(
            rangeSplit[0].toInt(),
            rangeSplit[1].toInt(),
            char,
            split[2]
        ))
    }

    return data
}

fun getDataForDay3(): List<String> {
    val data = mutableListOf<String>()
    File(DAY3_INPUT).forEachLine {
        data.add(it)
    }

    return data
}

fun getDataForDay4(): List<String> {
    val data = mutableListOf<String>()
    var tempLine = ""
    File(DAY4_INPUT).forEachLine {
        if (it.isBlank()) {
            data.add(tempLine)
            tempLine = ""
        } else {
            tempLine += " $it"
        }
    }
    data.add(tempLine)

    return data
}

fun getDataForDay5(): List<String> {
    val data = mutableListOf<String>()
    File(DAY5_INPUT).forEachLine {
        data.add(it)
    }

    return data
}

fun getDataForDay6(): List<String> {
    val data = mutableListOf<String>()
    var tempLine = ""
    File(DAY6_INPUT).forEachLine {
        if (it.isBlank()) {
            data.add(tempLine)
            tempLine = ""
        } else {
            tempLine += "$it "
        }
    }
    data.add(tempLine)

    return data
}

data class Password(
    val p1: Int,
    val p2: Int,
    val char: Char,
    val password: String
) {
    fun isValid(): Boolean = password.count { it == char } in p1..p2
    fun isValidNew(): Boolean = (password[p1-1] == char) xor (password[p2-1] == char)
}
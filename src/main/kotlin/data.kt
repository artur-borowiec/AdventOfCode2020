import java.io.File

const val DAY1_INPUT = "src/main/resources/input1.txt"
const val DAY2_INPUT = "src/main/resources/input2.txt"
const val DAY3_INPUT = "src/main/resources/input3"
const val DAY4_INPUT = "src/main/resources/input4"
const val DAY5_INPUT = "src/main/resources/input5"
const val DAY6_INPUT = "src/main/resources/input6"
const val DAY7_INPUT = "src/main/resources/input7"
const val DAY8_INPUT = "src/main/resources/input8"
const val DAY9_INPUT = "src/main/resources/input9"

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

fun getDataForDay7(): List<Bag> {
    val data = mutableListOf<Bag>()
    File(DAY7_INPUT).forEachLine {
        val bag = Bag(it.split("bags contain")[0].trim(), mutableListOf())
        val inside = it.split("bags contain")[1]
        val bags = inside.split(", ")
        bags.forEach { insideBag ->
            bag.inside.add(insideBag
                .replace("bags.", "")
                .replace("bags", "")
                .replace("bag.", "")
                .replace("bag", "")
                .trim()
            )
        }
        println("$bag ${bag.hasNoBagsInside()}")
        data.add(bag)
    }

    return data
}

fun getDataForDay8(): List<String> {
    val data = mutableListOf<String>()
    File(DAY8_INPUT).forEachLine {
        data.add(it)
    }

    return data
}

fun getDataForDay9(): List<Long> {
    val data = mutableListOf<Long>()
    File(DAY9_INPUT).forEachLine {
        data.add(it.toLong())
    }

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

data class Bag(
    val color: String,
    val inside: MutableList<String>
) {
    fun hasNoBagsInside() = inside[0].contains("no other")

    fun getBagsCount(): Int {
        if (hasNoBagsInside()) return 0
        var count = 0
        inside.forEach {
            println(it.split(" ")[0].toInt())
            count += it.split(" ")[0].toInt()
        }
        return count
    }

}

fun List<Bag>.getBag(color: String): Bag = this.filter { it.color == color }[0]

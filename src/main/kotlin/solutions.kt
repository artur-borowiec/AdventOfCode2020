import kotlin.math.abs

fun getSolution11(): Int {
    val data = getDataForDay1()
    data.forEach {
        if (data.contains(2020 - it))
            return (2020 - it) * it
    }

    return -1
}

fun getSolution12(): Int {
    val data = getDataForDay1()
    data.forEachIndexed { i1, el1 ->
        data.forEachIndexed { i2, el2 ->
            if (i2 > i1) {
                if (data.contains(2020 - (el1 + el2)))
                    return el1 * el2 * (2020 - el1 - el2)
            }
        }
    }

    return -1
}

fun getSolution21(): Int {
    val data = getDataForDay2()
    var validCount = 0
    data.forEach {
        if (it.isValid())
            validCount++
    }
    return validCount
}

fun getSolution22(): Int {
    val data = getDataForDay2()
    var validCount = 0
    data.forEach {
        if (it.isValidNew())
            validCount++
    }
    return validCount
}

fun getSolution31(): Int {
    var counter = 0
    var position = 0
    val data = getDataForDay3()
    val lineSize = data[0].length

    data.forEach {
        if (it[position] == '#')
            counter++

        position += 3
        if (position >= lineSize)
            position -= lineSize
    }

    return counter
}

fun getSolution32(): Int {
    var counter: Int
    var position: Int
    val data = getDataForDay3()
    val lineSize = data[0].length
    val params = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))

    var score = 0

    params.forEach { param ->
        counter = 0
        position = 0
        data.forEachIndexed { index, line ->
            if (index % param.second == 0) {
                if (line[position] == '#')
                    counter++

                position += param.first
                if (position >= lineSize)
                    position -= lineSize
            }
        }
        if (score == 0)
            score = counter
        else
            score *= counter
    }

    return score
}

fun getSolution41(): Int {
    var counter = 0
    val data = getDataForDay4()

    data.forEach {
        if (checkIfContainsAllFields(it))
            counter++
    }

    return counter
}

fun getSolution42(): Int {
    var counter = 0
    val data = getDataForDay4()

    data.forEach { passport ->
        run {
            var valid = checkIfContainsAllFields(passport)
            passport.split(" ").forEach { field ->
                if (!validateField(field)) valid = false
            }
            if (valid) counter++
        }
    }

    return counter
}

fun getSolution51(): Int? {
    val data = getDataForDay5()
    val ids = mutableListOf<Int>()

    data.forEach {
        var half = 64
        var rowL = 0
        var rowH = 127

        for (c in 0..5) {
            when (it[c]) {
                'F' -> rowH -= half
                'B' -> rowL += half
            }
            half /= 2
        }

        var id = if (it[6] == 'F') rowL * 8 else rowH * 8


        var half2 = 4
        var seatL = 0
        var seatH = 7
        for (c in 7..8) {
            when (it[c]) {
                'L' -> seatH -= half2
                'R' -> seatL += half2
            }
            half2 /= 2
        }

        id += if (it[9] == 'L') seatL else seatH

        ids.add(id)
        println("$it $id")
    }
    return ids.maxOrNull()
}

fun getSolution52(): Int {
    val data = getDataForDay5()
    val ids = mutableListOf<Int>()

    data.forEach {
        var half = 64
        var rowL = 0
        var rowH = 127

        for (c in 0..5) {
            when (it[c]) {
                'F' -> rowH -= half
                'B' -> rowL += half
            }
            half /= 2
        }

        var id = if (it[6] == 'F') rowL * 8 else rowH * 8


        var half2 = 4
        var seatL = 0
        var seatH = 7
        for (c in 7..8) {
            when (it[c]) {
                'L' -> seatH -= half2
                'R' -> seatL += half2
            }
            half2 /= 2
        }

        id += if (it[9] == 'L') seatL else seatH

        ids.add(id)
    }
    ids.sort()
    val diff = ids[0]
    ids.forEachIndexed { index, element ->
        if (element != diff + index) {
            return element-1
        }
    }
    return -1
}

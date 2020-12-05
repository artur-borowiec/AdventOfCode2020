fun getSolution11(): Int {
    val data = getDataForDay1()
    data.forEach {
        if (data.contains(SUM - it))
            return (SUM - it) * it
    }

    return -1
}

fun getSolution12(): Int {
    val data = getDataForDay1()
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
    val params = listOf(Pair(1,1), Pair(3,1), Pair(5,1), Pair(7,1), Pair(1,2))

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

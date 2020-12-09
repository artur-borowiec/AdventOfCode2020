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

fun getSolution51(): Int? = getSeatIds().maxOrNull()

fun getSolution52(): Int {
    val ids = getSeatIds()
    ids.sort()
    val diff = ids[0]
    ids.forEachIndexed { index, element ->
        if (element != diff + index) {
            return element - 1
        }
    }
    return -1
}

fun getSolution61(): Int {
    val data = getDataForDay6()
    var score = 0
    data.forEach {
        val s = it.replace(" ", "")
        score += s.toCharArray().toMutableSet().size
    }

    return score
}

fun getSolution62(): Int {
    val data = getDataForDay6()
    var score = 0
    data.forEach {
        val groups = it.trim().split(" ")
        groups[0].toCharArray().forEach { ch ->
            var allContain = true
            groups.forEach { group ->
                if(!group.contains(ch))
                    allContain = false
            }
            if (allContain) score += 1
        }
    }

    return score
}

fun getSolution71(): Int {
    val data = getDataForDay7()
    val resultSet = mutableSetOf<String>()
    val colorList = mutableListOf("shiny gold")
    val resultList = mutableListOf<String>()

    while (colorList.isNotEmpty()) {
        colorList.forEach { color ->
            data.forEach { bag ->
                bag.inside.forEach {
                    if(it.contains(color)) {
                        resultList.add(bag.color)
                        println(bag.color)
                    }
                }
            }
        }
        resultSet.addAll(resultList)
        colorList.clear()
        colorList.addAll(resultList)
        resultList.clear()
    }

    return resultSet.size
}

fun getSolution72(): Int {
    return 0
}

fun getSolution81(): Int {
    val data = getDataForDay8()
    val alreadyRan = mutableSetOf<Int>()
    var acc = 0
    var current = 0

    while (!alreadyRan.contains(current)) {
        when {
            data[current].contains("nop") -> {
                alreadyRan.add(current)
                current++
            }
            data[current].contains("jmp") -> {
                alreadyRan.add(current)
                current += data[current].split(" ")[1].toInt()
            }
            data[current].contains("acc") -> {
                alreadyRan.add(current)
                acc += data[current].split(" ")[1].toInt()
                current++
            }
        }
    }
    return acc
}

// ugly but works
fun getSolution82(): Int {
    val data = getDataForDay8()
    val alreadyRan = mutableSetOf<Int>()
    var acc: Int
    var current: Int

    // nop/jmp lines numbers
    val positions = mutableListOf<Int>()
    data.forEachIndexed { index, s ->
        run {
            if (s.contains("nop") || s.contains("jmp"))
                positions.add(index)
        }
    }

    positions.forEach {
        val editedData = mutableListOf<String>()
        acc = 0
        current = 0
        alreadyRan.clear()
        editedData.addAll(data)
        editedData[it] = editedData[it].swapp()

        while (!alreadyRan.contains(current)) {
            if (current>=editedData.size)
                return acc
            when {
                editedData[current].contains("nop") -> {
                    alreadyRan.add(current)
                    current++
                }
                editedData[current].contains("jmp") -> {
                    alreadyRan.add(current)
                    current += editedData[current].split(" ")[1].toInt()
                }
                editedData[current].contains("acc") -> {
                    alreadyRan.add(current)
                    acc += editedData[current].split(" ")[1].toInt()
                    current++
                }
            }
        }
    }
    return -1
}

fun getSolution91(): Long {
    val data = getDataForDay9()
    val nums = mutableListOf<Long>()
    val preamLength = 25

    data.forEach {
        if (nums.size < preamLength)
            nums.add(it)
        else {
            println(nums)
            println(it)
            var found = false
            nums.forEach { num ->
                val second = it-num
                if (nums.contains(second) && second!=it)
                    found = true
            }
            if (!found) return it
            nums.removeAt(0)
            nums.add(it)
        }
    }

    return -1
}

fun getSolution92(): Long {
    val data = getDataForDay9()
    val invNumber = 22477624L
    val contList = mutableListOf<Long>()

    data.forEachIndexed { i, _ ->
        var tempSum = 0L
        var position = i
        contList.clear()

        while (tempSum < invNumber) {
            tempSum += data[position]
            contList.add(data[position])
            position++

            if (tempSum == invNumber)
                return contList.maxOrNull()?.plus(contList.min() ?: -1) ?: -1
        }
    }

    return 0L
}

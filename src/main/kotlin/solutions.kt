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

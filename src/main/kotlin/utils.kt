fun checkIfContainsAllFields(s: String): Boolean {
    var contains = true
    val fields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fields.forEach {
        if(!s.contains(it))
            contains = false
    }

    return contains
}

fun validatePassword(s: String): Boolean {
    var isValid = true
    if (!checkIfContainsAllFields(s)) isValid = false

    val fields = s.split(" ")
    fields.forEach {
        validateField(it)
    }

    return isValid
}

fun validateField(s: String): Boolean =
    when {
        s.contains("byr:") -> s.replace("byr:", "").toInt() in 1920..2002
        s.contains("iyr:") -> s.replace("iyr:", "").toInt() in 2010..2020
        s.contains("eyr:") -> s.replace("eyr:", "").toInt() in 2020..2030
        s.contains("hgt:") -> {
            val hgt = s.replace("hgt:", "")
            when {
                hgt.contains("cm") -> hgt.replace("cm", "").toInt() in 150..193
                hgt.contains("in") -> hgt.replace("in", "").toInt() in 59..76
                else -> false
            }
        }
        s.contains("hcl:") -> "#([0-9a-f]){6}".toRegex().matches(s.replace("hcl:", ""))
        s.contains("ecl:") ->
            s.replace("ecl:", "") in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        s.contains("pid:") -> "([0-9]){9}".toRegex().matches(s.replace("pid:", ""))
        else -> true
    }


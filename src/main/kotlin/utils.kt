fun checkIfContainsAllFields(s: String): Boolean {
    var contains = true
    val fields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fields.forEach {
        if(!s.contains(it))
            contains = false
    }

    return contains
}

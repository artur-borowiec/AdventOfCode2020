// for day 8
fun String.swapp(): String {
    when {
        this.contains("jmp") -> return this.replace("jmp", "nop")
        this.contains("nop") -> return this.replace("nop", "jmp")
    }
    return this
}

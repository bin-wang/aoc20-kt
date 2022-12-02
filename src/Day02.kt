fun main() {
    fun occurrenceRule(minOccurrences: Int, maxOccurrences: Int, c: Char, password: String) =
        password.count { it == c } in minOccurrences..maxOccurrences

    fun positionRule(leftIndex: Int, rightIndex: Int, c: Char, password: String) =
        (password[leftIndex - 1] == c) xor (password[rightIndex - 1] == c)

    fun checkPassword(rawInput: String, rule: (Int, Int, Char, String) -> Boolean): Boolean {
        val regex = Regex("(\\d+)-(\\d+) (\\w): (\\w+)")
        val match = regex.find(rawInput)!!
        val (a, b, c, password) = match.destructured
        return rule(
            a.toInt(),
            b.toInt(),
            c.first(),
            password
        )
    }


    fun part1(input: List<String>): Int {
        return input.map { checkPassword(it, ::occurrenceRule) }.count { it }
    }

    fun part2(input: List<String>): Int {
        return input.map { checkPassword(it, ::positionRule) }.count { it }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 1)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

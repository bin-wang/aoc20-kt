fun main() {
    fun countTrees(input: List<String>, xSlope: Int, ySlope: Int): Int {
        val h = input.size
        val w = input.first().length
        val posSequence = generateSequence(Pair(0, 0)) {
            if (it.second + ySlope < h) Pair(
                it.first + xSlope,
                it.second + ySlope
            ) else null
        }
        return posSequence.map { (x, y) ->
            input[y][x % w] == '#'
        }.count { it }
    }

    fun part1(input: List<String>): Int {
        return countTrees(input, 3, 1)
    }

    fun part2(input: List<String>): Long {
        val slopeList = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
        return slopeList.map { (xSlope, ySlope) ->
            countTrees(input, xSlope, ySlope).toLong()
        }.reduce(Long::times)
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 336L)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

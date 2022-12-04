fun main() {
    fun findProductWithSum(nums: List<Int>, target: Int): Int? {
        var head = 0
        var tail = nums.size - 1
        while (head < tail) {
            val sum = nums[head] + nums[tail]
            when {
                sum < target -> head++
                sum > target -> tail--
                else -> {
                    return nums[head] * nums[tail]
                }
            }
        }
        return null
    }

    fun part1(input: List<String>): Int {
        val expenses = input.map(Integer::parseInt).sorted()
        return findProductWithSum(expenses, 2020) ?: error("No solution found")
    }

    fun part2(input: List<String>): Int {
        val expenses = input.map(Integer::parseInt).sorted()
        for ((i, v) in expenses.withIndex()) {
            val product = findProductWithSum(expenses.slice(i + 1 until expenses.size), 2020 - v)
            if (product != null) {
                return product * v
            }
        }
        error("No solution found")
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 514579)
    check(part2(testInput) == 241861950)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

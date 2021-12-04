package day1

import readInput

fun main() {
    val input = readInput("Day01")

    part1(input)
    part2(input)
}

private fun part1(input: List<String>): Int {
    var result = 0
    input.forEachIndexed { index, string ->
        if (index < input.size - 1) {
            if (input[index].toInt() < input[index + 1].toInt()) {
                result += 1
            }
        }
    }
    println(result)
    return result
}

private fun part2(input: List<String>): Int {
    var result = 0
    var sum: Int
    input.forEachIndexed { index, string ->
        if (index < input.size - 3) {
            sum = sumOfThreeNumbersFromIndex(index, input)
            if ( sum < sumOfThreeNumbersFromIndex(index+1, input)) {
                result += 1
            }
        }
    }
    println(result)
    return result
}

private fun sumOfThreeNumbersFromIndex(index: Int, input: List<String>) : Int {
    var sum = 0
    input.subList(index, index+3).forEach { number->
        sum += number.toInt()
    }
    return sum
}
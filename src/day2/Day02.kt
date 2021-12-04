package day2

import Day02
import readInput

fun main() {
    val input = readInput("Day02")
    val input2 = readInput("Day02")

    println(part1(input))
    println(part2(input2))
}

private fun part1(input: List<String>): Int {
    var x = 0
    var y = 0
    input.forEachIndexed { index, string ->
        val array = string.split(" ")
        when (array[0]) {
            Day02.down.name -> y += array[1].toInt()
            Day02.up.name -> y -= array[1].toInt()
            Day02.forward.name -> x += array[1].toInt()
        }
    }
    return x * y
}

private fun part2(input: List<String>): Int {
    var x = 0
    var y = 0
    var aim = 0
    input.forEachIndexed { index, string ->
        val array = string.split(" ")
        when (array[0]) {
            Day02.down.name -> {

                aim += array[1].toInt()
            }
            Day02.up.name -> {

                aim -= array[1].toInt()
            }
            Day02.forward.name -> {
                y += aim * array[1].toInt()
                x += array[1].toInt()
            }
        }
    }
    return x * y
}

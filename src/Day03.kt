import kotlin.math.absoluteValue
import kotlin.math.pow

fun main() {
    val input = readInput("Day03")
    val input2 = readInput("Day03")

    println(part1(input))
    println(part2(input2))
}

private fun part1(input: List<String>): Int {
    val hashMap = mutableMapOf<Int, Int>()
    input.forEachIndexed { index, string ->
        string.toCharArray().forEachIndexed { index, char ->
            if (char == '0')
                hashMap[index] = hashMap.getOrDefault(index, 0) + 1
            else
                hashMap[index] = hashMap.getOrDefault(index, 0) - 1
        }
    }
    val array = mutableListOf<Int>()
    var number = 0
    var number2 = 0
    hashMap.forEach { (t, u) ->
        if (u < 0)
            array.add(t, 1)
        else
            array.add(t, 0)
    }
    array.forEachIndexed { index, i ->
        number += i * (2.0).pow(hashMap.size - (index.absoluteValue) - 1).toInt()
        if (i == 0) {
            number2 += (2.0).pow(hashMap.size - (index.absoluteValue) - 1).toInt()
        }
    }

    return number * number2
}

private fun part2(input: List<String>): Int {
    val list = getMostBit(input, 0, '1', '0')

    var number1 = 0
    list.forEach { string ->
        string.forEachIndexed { index, c ->
            if (c == '1')
                number1 += (2.0).pow(string.length - (index.absoluteValue) - 1).toInt()
        }
    }

    val list2 = getMostBit(input, 0, '0', '1')
    var number2 = 0
    list2.forEach { string ->
        string.forEachIndexed { index, c ->
            if (c == '1')
                number2 += (2.0).pow(string.length - (index.absoluteValue) - 1).toInt()
        }
    }

    return number2 * number1
}

private fun getMostBit(input: List<String>, position: Int, firstChar: Char, secondChar: Char): List<String> {
    return if
                   (input.size <= 1) input
    else {
        val hashMap = mutableMapOf<Int, Int>()
        input.forEachIndexed { index, string ->
            println("index =$index numbers=$string && string[0]=${string[0]}")
            val char = string[position]
            if (char == '0')
                hashMap[position] = hashMap.getOrDefault(position, 0) + 1
            else
                hashMap[position] = hashMap.getOrDefault(position, 0) - 1
        }

        val char = if (hashMap[position]!! > 0)
            firstChar
        else
            secondChar

        val list = input.filterNot { it[position] == char }

        getMostBit(list, position + 1, firstChar, secondChar)
    }
}

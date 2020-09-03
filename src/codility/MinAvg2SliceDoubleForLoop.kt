package codility

import java.util.*

fun solutionMinAvgSliceD(A: IntArray): Int {

    var divisor = 0
    var smallest = Double.MAX_VALUE
    var b = 0
    var smallestIndice = 0
    for (i in 0 until A.lastIndex) {
        val j = i + 1
        val currentPoint = A[i]

        for (d in j until A.size) {
            b += A[d]
            divisor += 1
            val result = (b.toDouble() + currentPoint.toDouble()) / (divisor.toDouble() + 1.0)
            if (result < smallest) {
                smallest = result
                smallestIndice = i
            }
        }
        b = 0
        divisor = 0
    }
    return smallestIndice

}

fun solutionMinAvgSlicef(A: IntArray): Int {
    var smallest = Double.MAX_VALUE
    var smallestIndice = Int.MAX_VALUE

    for (i in 0 until A.size - 2) {
        val sum1 = A[i].toDouble() + A[i + 1].toDouble()
        val avg1 = sum1 / 2.0
        if (avg1 < smallest) {
            smallest = avg1
            smallestIndice = i
        }

        val sum2 = A[i].toDouble() + A[i + 1].toDouble() + A[i + 2].toDouble()
        val avg2 = sum2 / 3.0
        if (avg2 < smallest) {
            smallest = avg2
            smallestIndice = i
        }
    }

    val sum3 = A[A.size - 2].toDouble() + A.last().toDouble()
    val avg3 = sum3 / 2.0
    if (avg3 < smallest) {
        smallestIndice = A.size - 2
    }


    return smallestIndice
}


fun main() {
    val scan = Scanner(System.`in`)
    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()
    val solution = solutionMinAvgSlicef(A)
    println(solution)
}
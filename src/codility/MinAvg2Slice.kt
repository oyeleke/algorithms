package codility

import java.util.*

fun solutionMinAvgSlice(A: IntArray): Int {
    // write your code in Kotlin
    val prefixSum = prefixSums(A)
    var i = 0
    var j = 2
    var smallest = Double.MAX_VALUE
    var result = 0.0
    var smallestIndices = Int.MAX_VALUE

    if (A.size == 2){
        return (A[1] + A[2])/2
    }

    while (j < prefixSum.size){
        if (i == prefixSum.size - 1){
            return smallestIndices
        }
        if (i >= 0) {
            if(j-i > 1) {
                result = (prefixSum[j].toDouble() - prefixSum[i].toDouble()) / ((j.toDouble() - i.toDouble()))
            }
        }
        if (result < smallest && j > 1){
            smallest = result
            smallestIndices = i
        }


        if (j == prefixSum.lastIndex){
            i += 1
            j = i+1
        }
        j += 1
    }
    return smallestIndices
}

fun prefixSums(A: IntArray): IntArray {
    val sums = IntArray(A.size + 1)
    for (i in 1 until A.size + 1){
        sums[i] = sums[i-1] + A[i-1]
    }

    return sums
}

fun main(){
    val scan = Scanner(System.`in`)
    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()
    val solution = solutionMinAvgSlice(A)
    println(solution)
}
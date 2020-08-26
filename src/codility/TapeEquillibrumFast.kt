package codility


import kotlin.math.abs

fun main(){
    fun solution(A: IntArray): Int {
        // write your code in Kotlin
        if (A.size == 2){
            return abs(A[0] - A[1])
        }

        var sumFirst = 0
        var sumAllNumbers = 0
        var sumSecond: Int
        var currentDifference: Int
        var minDifference = Int.MAX_VALUE
        for (element in A) {
            sumAllNumbers += element
        }

        for (j in 0 until A.lastIndex ){
            sumFirst += A[j]
            sumSecond = sumAllNumbers - sumFirst
            currentDifference = abs(sumFirst - sumSecond)
            minDifference = minOf(currentDifference, minDifference)
        }

        return minDifference

    }

    val d: IntArray = readLine()!!.split(" ").map { it.trim().toInt() }.toIntArray()
    println(solution(d))
}
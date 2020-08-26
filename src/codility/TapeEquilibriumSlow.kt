package codility

import kotlin.math.abs

fun main(){
    fun solution(A: IntArray): Int {
        // write your code in Kotlin
        if (A.size == 2){
            return abs(A[0] - A[1])
        }

        val sums = IntArray(A.size - 1)
        var sumFirst: Int = 0
        var sumSecond: Int = 0
        var j = 1
        for (i in 0 until A.lastIndex) {

            sumFirst += A[i]
            for (d in j until A.size) {
                sumSecond += A[d]
            }

            ++j
            sums[i] = abs(sumFirst - sumSecond)
            sumSecond = 0
        }

        for (a in sums){
            print("$a ")
        }
        println()
        return sums.min()!!
    }

    val d: IntArray = readLine()!!.split(" ").map { it.trim().toInt() }.toIntArray()
    println(solution(d))
}
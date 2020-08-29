package codility

import java.util.*
import kotlin.math.max
import kotlin.math.min


fun solution(A: IntArray, k: Int, m:Int): Int{
    var result = 0
    val n = A.size
    println("var n $n")
    val pref = prefixSum(A)
    //get the optimum right side first
    for (i in 0 until (min(k, m)+ 1)){
        var leftPos = k-i
        var rightPos = min(A.lastIndex, max(k, k + m - (2 * i)))
        result = max(result, countTotal(pref, leftPos, rightPos))
        println("1st forloop: leftPos $leftPos, rightpos $rightPos , result: $result  ")
    }

    for (i in 0 until min(n-k, m+1 )){
        var rightPos = k + i
        var leftPos = max(0, min(k, k-(m-2*i)))
        result =  max(result, countTotal(pref, leftPos, rightPos))
        println("2nd forloop: leftPos $leftPos, rightpos $rightPos , result: $result  ")
    }

    return result
}

fun prefixSum(A: IntArray): IntArray{
    val prefixSumArray = IntArray(A.size+1)
    for (i in 1 until A.size+1){
        prefixSumArray[i] = prefixSumArray[i-1] + A[i-1]
    }
    println("perfixsumarray size")
    return prefixSumArray
}

fun countTotal(A: IntArray, x: Int, y:Int): Int{
    return A[y+1] - A[x]
}

fun mushroomPicker(A: IntArray, k: Int, m: Int): Int{
    return solution(
        A = A,
        k = k,
        m = m
    )
}

fun main(){
    val scan = Scanner(System.`in`)
    val k = scan.nextLine().trim().toInt()
    val m = scan.nextLine().trim().toInt()
    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()
    val solution = mushroomPicker(A, k, m)
    print(solution)
}
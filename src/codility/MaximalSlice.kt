package codility

import java.util.*
import kotlin.math.max

fun solutionMaxSlice(A: IntArray): Int{
    var maxSlice = Int.MIN_VALUE
    var maxEnding = 0

    for (a in A){
        maxEnding = max(a, maxEnding + a)
        maxSlice = max(maxSlice, maxEnding)
    }
    return maxSlice
}

fun main(){
    val scan = Scanner(System.`in`)
    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()
    print(solutionMaxSlice(A))
}
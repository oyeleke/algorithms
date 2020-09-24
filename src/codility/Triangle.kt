package codility

import java.util.*

fun solutionTriangle(A: IntArray): Int {
    var max = 0
    if (A.size < 3){
        return 0
    }

    if (A.size == 3){
        if (A[0] + A[1] > A[2]){
            return 1
        } else {
            return 0
        }
    }

    A.sort()


    for (i in 0 until A.lastIndex-1){
        if (A[i] + A[i+1] > A[i+2]){
            max = 1
            break
        }
    }

    return max
}

fun main() {
    val scan = Scanner(System.`in`)

    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

    val solution = solutionTriangle(A)
    print("$solution ")
}

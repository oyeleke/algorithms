package codility

import java.util.*

fun solutionDistinct(A: IntArray): Int {
    // write your code in Kotlin
    return A.toSet().size
}

fun main() {
    val scan = Scanner(System.`in`)
    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()
    print(solutionDistinct(A))
}
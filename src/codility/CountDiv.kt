package codility

import kotlin.math.ceil
import kotlin.math.floor

fun solutionCountDiv(A: Int, B: Int, K: Int): Int {
    // write your code in Kotlin
    return (B / K) - (A + K - 1) / K + 1
}

fun solutionCountDiv1(A: Int, B: Int, K: Int): Int {
    // write your code in Kotlin
    return if (A % K == 0) {
        (B - A) / K + 1
    } else {
        (B - (A - A % K)) / K
    }
}

fun solutionCountDiv2(A: Int, B: Int, K: Int): Int {
    // write your code in Kotlin
    val c = floor(B.toDouble()/K.toDouble()) - ceil(A.toDouble()/K.toDouble())
    return c.toInt() + 1

}


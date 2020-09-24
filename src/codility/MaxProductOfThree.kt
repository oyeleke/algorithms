package codility

import kotlin.math.abs


fun solutionMaxProduct(A: IntArray): Int {
    // write your code in Kotlin
    var result = 0
    var multipleArray = IntArray(6)
    if (A.size == 3) {
        return A[0] * A[1] * A[2]
    }

    A.sort()

    if (A[A.lastIndex] < 0) {
        return A[A.lastIndex] * A[A.lastIndex - 1] * A[A.lastIndex - 2]
    } else if (A[A.lastIndex] == 0) {
        return 0
    } else if (A[0] >= 0) {
        return A[A.lastIndex] * A[A.lastIndex - 1] * A[A.lastIndex - 2]
    } else {
        if (A.size <= 6) {
            multipleArray = A
        } else {
            multipleArray = intArrayOf(A[0], A[1], A[2], A[A.lastIndex - 2], A[A.lastIndex - 1], A[A.lastIndex])
        }
        val first = multipleArray[0] * multipleArray[1] * multipleArray[multipleArray.lastIndex]
        val second = multipleArray[multipleArray.lastIndex] * multipleArray[multipleArray.lastIndex-1] * multipleArray[multipleArray.lastIndex-2]
        result = if (first > second) first else second
    }
    return result
}

package codility

fun solutionCountDiv(A: Int, B: Int, K: Int): Int {
    // write your code in Kotlin
    return (B/K) - ((A+K-1))/K + 1
}
package codility

fun solutionPassingCars(A: IntArray): Int {
    // write your code in Kotlin
    var noOfOccurs: Array<IntArray> = Array(A.size) { IntArray(2) }
    var pairs = 0
    //calculate no of occurrences for 0s and 1s

    for (i in noOfOccurs.indices) {
        when (A[i]) {
            0 -> noOfOccurs[i][0] = 1
            1 -> noOfOccurs[i][1] = 1
        }
    }

    //add all occurrence to ensure we know the amount of zeros at every position

    for (i in 1 until noOfOccurs.size){
        for (j in 0 until 2){
            noOfOccurs[i][j] += noOfOccurs[i-1][j]
        }
    }

    //calculate all pairs till the last 0
    val max1s = noOfOccurs[noOfOccurs.lastIndex][1]
    for (i in noOfOccurs.indices){
        if (A[i] == 0){
            pairs += (max1s - noOfOccurs[i][1])
        }

        if (pairs > 1000000000){
            pairs = -1
            break
        }
    }

    return pairs
}
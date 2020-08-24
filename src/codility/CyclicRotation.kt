package codility

import java.util.*

fun solution(A: IntArray, K: Int): IntArray {
    // write your code in Kotlin
    val newArray = IntArray(A.size)

    if (A.size <= 1){
        return A
    }
    for (i in 0..A.lastIndex){
        var d = i + K
        while (d >= A.size){
            d -= A.size
        }
        newArray[d] = A[i]
    }

    return newArray
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val noOfRotations = scan.nextLine().toInt()


    val array = scan.nextLine().split(" ").map { it.trim().toInt() } .toIntArray()

    val solution = solution(array, noOfRotations)
    for (element in solution){
        print("$element ")
    }
}
package codility

import java.util.*

fun solutionDiscInterceptions(A: IntArray): Int {
    // write your code in Kotlin
    val highestPointArray = IntArray(A.size)
    val lowestPointArray = IntArray(A.size)
    var count = 0

    if (A.size < 2){
        return 0
    }

    for (i in A.indices){
        highestPointArray[i] = i + A[i]
        lowestPointArray[i] = i - A[i]
    }

    for (i in A.indices){

        for (j in i until A.lastIndex){
            if (highestPointArray[i] >= lowestPointArray[j + 1]){
                count += 1
            }

            if (count > 10000000){
                count = -1
                break
            }
        }
    }

    return count
}

fun solutionDiscInterceptions2(A: IntArray): Int {
    val highestPointArray = IntArray(A.size)
    val lowestPointArray = IntArray(A.size)
    var openDisks = 0
    var intersections = 0
    var closed = 0

    if (A.size < 2){
        return 0
    }

    for (i in A.indices){
        highestPointArray[i] = i + A[i]
        lowestPointArray[i] = i - A[i]
    }
    highestPointArray.sort()
    lowestPointArray.sort()

    outer@for(i in lowestPointArray.indices){

        inner@for (j in closed until highestPointArray.size ){
            if (lowestPointArray[i] > highestPointArray[j]){
                openDisks -= 1
                closed += 1
            }
            if (lowestPointArray[i] <= highestPointArray[j]){
                if (openDisks > 0) {
                    intersections += openDisks
                }
                openDisks += 1
                break@inner
            }
        }
        if (intersections > 10000000){
            intersections = -1
            break
        }
    }

    return intersections
}

fun main() {
    val scan = Scanner(System.`in`)

    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

    val solution = solutionDiscInterceptions2(A)
    print("$solution ")
}

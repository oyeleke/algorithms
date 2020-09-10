package codility

import java.util.*

fun solutionGenomic2(S: String, P: IntArray, Q: IntArray): IntArray {
    val occurrence :Array<IntArray> = Array(S.length){ IntArray(4) }
    val solution = IntArray(P.size)

    //first get occurrences for each genome
    for (i in occurrence.indices){
        when (S[i]) {
            'A' -> occurrence[i][0] = 1
            'C' -> occurrence[i][1] = 1
            'G' -> occurrence[i][2] = 1
            'T' -> occurrence[i][3] = 1
        }
    }

    //add all occurrences to the previous one
    for (i in 1 until occurrence.size){
        for (j in 0 until 4){
            occurrence[i][j] += occurrence[i-1][j]
        }
    }

    for (i in P.indices){
        val index1 = P[i]
        val index2 = Q[i]

        for(j in 0 until 4){
            var lowerIndexCount = 0
            if (index1 - 1 >= 0){
                lowerIndexCount = occurrence[index1-1][j]
            }

            if ((occurrence[index2][j] - lowerIndexCount)> 0){
                solution[i] = j+1
                break
            }
        }
    }

    return solution
}

fun main() {
    val scan = Scanner(System.`in`)
    val A = scan.nextLine().split(" ")
    val S = A[0].trim().toString()
    val P = A[1].split(",").map { it.trim().toInt() }.toIntArray()
    val Q = A[2].split(",").map { it.trim().toInt() }.toIntArray()

    val solution = solutionGenomic2(S, P, Q)

    for (i in solution){
        print(i)
    }
}

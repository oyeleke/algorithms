package codility

import java.util.*
import kotlin.collections.ArrayList

fun solutions(X: Int, A: IntArray): Int {
    val max = A.max()!!

    if (max < X) {
        return -1
    }

    val count = IntArray(max)
    for (d in A.indices) {
        count[A[d]] += 1
        if (checkIfAllSpacesAreFilled(X, count)) {
            return d
        }
    }
    return -1
}

fun checkIfAllSpacesAreFilled(X: Int, count: IntArray): Boolean {
    for (i in 1 until X + 1) {
        if (count[i] == 0) {
            return false
        }
    }
    return true
}

fun solutionsFaster(X: Int, A: IntArray): Int {

    val requiredLeaves = HashSet<Int>()
    val gottenLeaves = HashSet<Int>()

    for (i in 1 until X + 1) {
        requiredLeaves.add(i)
    }

    for (i in A) {
        gottenLeaves.add(i)
        if (gottenLeaves.size < requiredLeaves.size) continue

        if (gottenLeaves.containsAll(requiredLeaves)) return i
    }

    return -1
}

fun main() {
    val scan = Scanner(System.`in`)

    val x = scan.nextLine().toInt()


    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

    val solution = solutions(x, A)
    print("$solution ")
}
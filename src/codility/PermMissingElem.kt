package codility

fun main() {
    fun solution(A: IntArray): Int {
        // write your code in Kotlin
        A.sort()
        var j = 1
        if (A.isEmpty()) {
            return j
        }

        if (A.size == 1) {
            if(A[0] == 1){
                return A[0]+1
            } else {
                return A[0] - 1
            }
        }

        if (A.size == 2) {
            return if (A[1] - A[0] == 1 && A[0] != 1) {
                A[0] - 1
            } else if (A[1] - A[0] != 1){
                A[0]+1
            } else {
                A[1] + 1
            }
        }

        for (i in 0 until A.lastIndex) {
            if ((A[i + 1] - A[i]) > 1) {
                j = if (((i + 2) <= A.lastIndex) && (A[i + 2] - A[i + 1]) == 1) {
                    A[i + 1] - 1
                } else {
                    A[i] + 1
                }
                break
            } else {
                j = if (A[0] == 1){
                    A[A.lastIndex] + 1
                } else {
                    A[0] - 1
                }

            }
        }
        return j
    }

    val d: IntArray = readLine()!!.split(" ").map { it.trim().toInt() }.toIntArray()
    println(solution(d))
}
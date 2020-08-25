package codility

fun main() {
    fun solution(A: IntArray): Int {
        // write your code in Kotlin
        A.sort()
        var j = 1
        if (A.size == 1 ){
            return A[0]
        }
        if (A.isEmpty()){
            return 0
        }

        if (A.size == 2){
            if (A[0] < A[1]){
                return A[0] + 1
            } else {
                return A[1] + 1
            }
        }

        for (i in 0..A.lastIndex - 1) {
            if ((A[i + 1] - A[i]) > 1) {
                j = A[i] + 1
                break
            }
        }
        return j
    }

    val d: IntArray = readLine()!!.split(" ").map { it.trim().toInt() }.toIntArray()
    println(solution(d))
}
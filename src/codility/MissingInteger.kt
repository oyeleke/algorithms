package codility

fun solution(A: IntArray): Int {
    val max = A.max()!!
    if (max < 0){
        return 1
    }
    val count = IntArray(max + 1)
    for (d in A){
        if (d >= 0) {
            count[d] += 1
        }
    }

    for (i in count.indices){
        if (count[i] == 0){
            if (i > 0) {
                return i
            }
        }
    }



    return count.size
}

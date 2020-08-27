package codility

fun solution(N: Int, A: IntArray): IntArray {
    // write your code in Kotlin
    var counters =  IntArray(N)
    for (a in A){
        if (a <= N){
            counters[a-1] += 1
        } else {
           var max = counters.max()
            if (max != null){
                for (i in 0..counters.lastIndex){
                    counters[i] = max
                }
            }
        }
    }
    return counters
}

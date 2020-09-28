package codility

fun solutionDominator(A: IntArray): Int {
    val noMap = HashMap<Int, Int?>()
    val half = A.size / 2
    var dominator = -1
    var index = 0

    for (a in A){
        noMap[a] = (noMap[a] ?: 0) + 1
    }

    for ((key,value) in noMap){
        if (value!! > half){
            dominator = key
            break
        }
    }

    if (dominator == -1){
        return dominator
    } else {
        for (i in A.indices){
            if(dominator == A[i]){
                index = i
                break
            }
        }
    }

    return index
}
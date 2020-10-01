package codility

import java.util.*
import kotlin.collections.HashMap


fun solutionEquileader(A: IntArray): Int {
    val stack = Stack<Int>()

    for (i in A.indices){
        if (stack.isEmpty()){
            stack.push(A[i])
        } else{
            if (stack.peek() == A[i]){
                stack.push(A[i])
            } else {
                stack.pop()
            }
        }
    }
    if (stack.isEmpty()) return 0
    val candidate = stack.peek()
    var dominatorCount = 0
    val dominatorMap = HashMap<Int, Int>()
    for (i in A.indices){
        if (A[i] == candidate){
            dominatorCount++
            dominatorMap[i] = dominatorCount
        }
    }

    var runningDominatorCount = 0
    var lastOccurrence = 0
    var equileader = 0
    if (dominatorCount > A.size/2){
        for (i in A.indices){
            if (A[i] == candidate){
                lastOccurrence = i
                runningDominatorCount = dominatorMap[i]!!
            } else{
                if (dominatorMap[lastOccurrence] != null){
                    runningDominatorCount = dominatorMap[lastOccurrence]!!
                }
            }

            if (runningDominatorCount > ((i+1)/2)){
                if (dominatorCount - runningDominatorCount > (A.size - (i+1))/2){
                    equileader++
                }
            }
        }
    }

    return equileader
}





package codility

import java.util.*

fun solutionMaxProfit(A: IntArray): Int{
    var largestDiff = 0
    val stack = Stack<Int>()

    if (A.size < 2){
        return 0
    }
    stack.push(A[0])

    for (i in 1 until A.size){
        if (stack.peek() > A[i]){
            stack.pop()
            stack.push(A[i])
        } else {
            val diff = A[i] - stack.peek()
            if (diff > largestDiff) largestDiff = diff
        }
    }

    return largestDiff
}

fun main(){
    val scan = Scanner(System.`in`)
    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()
    print(solutionMaxProfit(A))
}
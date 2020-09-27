package codility

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun solution(A: IntArray, B: IntArray): Int {

    val stack = ArrayList<Int>()
    var map = HashMap<Int, Int>()
    val positionStack = 0

    if (A.size == 1){
        return 1
    }
    if (A.size == 2){
        return if (B[0] == 1 && B[1] == 0){
            1
        } else 2
    }

    for (i in A.indices){
        map[A[i]] = B[i]
    }

    stack.add(A[0])

    outer@ for (i in 1 until A.size){
        val start = stack.lastIndex
        inner@for(j in start downTo   0) {
            if (map[A[j]] == 1 && B[i] == 0) {
                if (stack[j] < A[i]) {
                    stack.removeAt(j)
                    if (stack.last() != A[i]) {
                        stack.add(A[i])
                    }
                }

                if (stack[j] > A[i]){
                    if (stack.last() == A[i]){
                        stack.removeAt(j)
                        break@inner
                    }else {
                        break@inner
                    }
                }
            } else {
                if (stack.last() != A[i]){
                    stack.add(A[i])
                }
                break@inner
            }
        }
    }
    return stack.size
}

fun solution2(A: IntArray, B: IntArray): Int{
    val stack = Stack<Fish2>()
    val upstream = 0
    stack.push(Fish2(A[0], B[0]))

    for (i in 1 until A.size){
        if (B[i] == stack.peek().direction){
            stack.push(Fish2(A[i], B[i]))
        } else if (stack.peek().direction == upstream){
            stack.push(Fish2(A[i], B[i]))
        } else {
            while (!stack.isEmpty()){
                if (stack.peek().direction == B[i]){
                    stack.push(Fish2(A[i], B[i]))
                    break
                } else {
                    if (stack.peek().size > A[i]){
                        break
                    } else {
                        stack.pop()
                    }
                }
            }
            if (stack.isEmpty()){
                stack.push(Fish2(A[i], B[i]))
            }
        }
    }
    return stack.size
}
data class Fish2(val size: Int, val direction: Int)

fun main() {
    val scan = Scanner(System.`in`)
    val nd = scan.nextLine().split(" ")

    val A = nd[0].split(",").map { it.trim().toInt() }.toIntArray()
    val B = nd[1].split(",").map { it.trim().toInt() }.toIntArray()

    val solution = solution2(A, B)
    print("$solution ")
}
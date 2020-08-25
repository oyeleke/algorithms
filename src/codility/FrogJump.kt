package codility

import java.util.*

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(X: Int, Y: Int, D: Int): Int {
    var noOfJumps = (Y-X)/D

    if ((Y-X)%D > 0){
        noOfJumps += 1
    }
    return noOfJumps
}
fun main() {
    val scan = Scanner(System.`in`)
    val nd = scan.nextLine().split(" ")
    val X = nd[0].trim().toInt()
    val Y = nd[1].trim().toInt()
    val D = nd[2].trim().toInt()
    println(solution(X,Y,D))
}
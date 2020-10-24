package codility

import java.util.*

fun solutionReversingCoins(n: Int): Int{
    var result = 0
    val coins = IntArray(n+1)
    for (i in 1..n){
        var k = i
        while (k <= n){
            coins[k] = (coins[k] + 1) % 2
            k += i
        }

        result += coins[i]
    }

    return result
}

fun main(){
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()

    print(solutionReversingCoins(n))
}
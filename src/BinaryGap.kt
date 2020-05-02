fun main() {

    fun solution(N: Int): Int {
        // write your code in Kotlin
        var listOfZeros = mutableListOf<Int>()
        var binaryNo = N.toString(2)
        var isOne = false
        var validZeroMet = false
        var isOneHasbeenMet = false
        var i = 0

        binaryNo.forEach { number ->
            if (number == '1') {
                isOne = true
                isOneHasbeenMet = true
            }

            if (isOneHasbeenMet && number == '0') {
                validZeroMet = true
                i += 1
                isOne = false
            }

            if (isOne && validZeroMet) {
                listOfZeros.add(i)
                i = 0
                validZeroMet = false
            }

        }
        return listOfZeros.max() ?: 0
    }

    val no: Int = readLine()!!.toInt()

    println(solution(no))


}

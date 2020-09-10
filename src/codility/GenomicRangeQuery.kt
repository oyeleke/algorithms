package codility

fun solution(S: String, P: IntArray, Q: IntArray): IntArray {

    val answer = IntArray(P.size)
    for (i in Q.indices){
      val sub =   S.subSequence(P[i], Q[i]).toString()
        answer[i] = convertStringtoNumbers(sub)
    }

    return answer
}

fun convertStringtoNumbers(letter: String): Int{
    return if (letter.contains("A")){
        1
    } else if (letter.contains("C")){
        2
    } else if (letter.contains("G")){
        3
    } else {
        4
    }
}

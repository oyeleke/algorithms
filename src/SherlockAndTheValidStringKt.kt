import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.math.abs
import kotlin.text.*

// Complete the isValid function below.
fun isValid(s: String): String {

    val stringArray = s.toCharArray()
    val strMap: HashMap<Char, Int?> = HashMap()
    val noOfString: HashMap<Int, Int?> = HashMap()
    var noOfNumOccurenceGreaterThan1 = 0

    var message = "NO"

    for (char in stringArray) {
        strMap[char] = (strMap[char] ?: 0) + 1
    }
    for (num in strMap.values) {
        noOfString[num!!] = (noOfString[num] ?: 0) + 1
    }

    if (noOfString.keys.count() == 1) {
        message = "YES"
    }

    if (noOfString.keys.count() == 2) {
        for (values in noOfString.values) {
            if (values!! > 1) {
                noOfNumOccurenceGreaterThan1 += 1
            }
        }

        if (noOfNumOccurenceGreaterThan1 == 1) {
            if (abs(noOfString.keys.first() - noOfString.keys.last()) == 1) {
                message = "YES"
            }

            if (noOfString.keys.contains(1)) {
                if (noOfString[1] == 1) {
                    message = "YES"
                }
            }
        }
    }


    return message
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = isValid(s)

    println(result)
}
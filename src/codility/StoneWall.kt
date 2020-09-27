package codility

import java.util.*

fun solutionwall(H: IntArray): Int {

    val stack = Stack<Int>()
    var count = 0

    if (H.size == 1) {
        return 1
    }

    stack.push(H[0])
    count = 1


    for (i in 1 until H.size) {
        if (stack.peek() != H[i]) {
            count += 1
        }

        stack.push(H[i])

    }

    return count
}

fun solutionwall2(H: IntArray): Int {
    val currentBlock = Block2(0, H[0])
    val blockStack = Stack<Block2>()

    blockStack.push(currentBlock)
    var blockRequired = 1
    for (i in 1 until H.size){
        var topStackBlock2 = blockStack.peek()
        while (topStackBlock2.higherHeight > H[i]){
            blockStack.pop()
            if (!blockStack.isEmpty()){
                topStackBlock2 = blockStack.peek()
            } else break
        }

        if (blockStack.isEmpty()){
            blockStack.push(Block2(0, H[i]))
            blockRequired++
        } else if(blockStack.peek().higherHeight - H[i] == 0){
            continue
        }
        else {
            topStackBlock2 = blockStack.peek()
            blockStack.push(Block2(blockStack.peek().higherHeight, H[i]))
            blockRequired++
        }
    }
    return blockRequired
}

data class Block2(val lowerHeight: Int, val higherHeight: Int)

fun main() {
    val scan = Scanner(System.`in`)

    val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

    val solution = solutionwall(A)
    print("$solution ")
}

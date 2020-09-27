package codility;

import java.util.Stack;

public class StoneWall {
    public int solution(int[] H) {

        //e.g. H[0] = 2 would be a block of size (0, 2)
        Block currentBlock = new Block(0, H[0]);
        Stack<Block> blockStack = new Stack();

        blockStack.add(currentBlock);
        int blocksRequired = 1;

        for (int i = 1; i < H.length; i++) {
            Block topStackBlock = blockStack.peek(); //remove any stack blocks that are taller than current block
            while (topStackBlock.upperHeight > H[i]) {
                blockStack.pop();
                if (!blockStack.isEmpty()) {
                    topStackBlock = blockStack.peek();
                } else break;
            }

            if (blockStack.isEmpty()) {
                blockStack.push(new Block(0, H[i]));
                blocksRequired++;
            }
            //block already exists in stack
            else if (blockStack.peek().upperHeight - H[i] == 0) {
                continue;
            }
            //put in a new block - need to calculate delta between tallest stack block and current block
            else {
                topStackBlock = blockStack.peek();
                blockStack.push(new Block(blockStack.peek().upperHeight, H[i]));
                blocksRequired++;
            }
        }

        return blocksRequired;
    }

    class Block {
        int lowerHeight;
        int upperHeight;

        Block(int pLowerHeight, int pUpperHeight) {
            lowerHeight = pLowerHeight;
            upperHeight = pUpperHeight;
        }
    }
}

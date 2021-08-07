package algoerxpertss.stacks;

import java.util.*;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] array) {
        if (array == null || array.length == 0) return array;

        int[] result = new int[array.length];
        Deque<Integer> staticStack = new LinkedList<>();

        for (int i : array)
        {
            staticStack.addLast(i);
        }

        for (int i = 0; i< array.length; i++){
            int current = array[i];
            Deque<Integer> notStaticStack = new LinkedList<>(staticStack);
            Integer currentNumberInArray = notStaticStack.removeFirst();
            while (currentNumberInArray != null){
                if (currentNumberInArray > current){
                    result[i] = currentNumberInArray;
                    break;
                } else {
                    try {
                        currentNumberInArray = notStaticStack.removeFirst();
                    }catch (NoSuchElementException e){
                        currentNumberInArray = null;
                    }
                }
            }

            if (currentNumberInArray == null){
                result[i] = -1;
            }

            int temp = staticStack.removeFirst();
            staticStack.addLast(temp);
        }
        // Write your code here.
        return result;
    }

    public int[] nextGreaterElements(int[] array) {
        int [] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> integerStack = new Stack<Integer>();

        for (int idx = 0; idx < 2 * array.length; idx++){
            int circularIdx = idx % array.length;

            while(!integerStack.empty() && array[integerStack.peek()] < array[circularIdx]){
                int top = integerStack.pop();
                result[top] = array[circularIdx];
            }

            integerStack.push(circularIdx);
        }

        return result;
    }
    }

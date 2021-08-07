package algoerxpertss.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        if (str == null || str.isEmpty()) {
            return false;
        }
        Deque<Character> charStack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                charStack.addFirst(str.charAt(i));
            } else {
                if (!isClosingBracket(str.charAt(i))) {
                    continue;
                }
                if (charStack.isEmpty() || (str.charAt(i) == '}' && charStack.peekFirst() != '{') || (str.charAt(i) == ')' && charStack.peekFirst() != '(')
                        || (str.charAt(i) == ']' && charStack.peekFirst() != '[')) {
                    return false;
                } else {
                    charStack.removeFirst();
                }
            }

        }

        return charStack.isEmpty();
    }

    public static  boolean isClosingBracket(Character c){
        if (c == ']' || c == '}' || c == ')') return true;
        return false;
    }
}

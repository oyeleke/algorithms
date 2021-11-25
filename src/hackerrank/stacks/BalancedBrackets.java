package hackerrank.stacks;

import java.util.HashSet;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        HashSet<Character> opening = new HashSet<>();
        opening.add('(');
        opening.add('[');
        opening.add('{');


        for (int i = 0; i< s.length(); i++){

            if (opening.contains(s.charAt(i))){
                stack.push(s.charAt(i));
            } else {

                if (!stack.isEmpty() && ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == ']' && stack.peek() == '[') || (s.charAt(i) == '}' && stack.peek() == '{') )) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }


}

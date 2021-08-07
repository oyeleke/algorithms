package elements_of_programming_interviews;

import java.util.Deque;
import java.util.LinkedList;

public class WellFormedStrings {
    public static boolean isWellFormed(String s){
        Deque<Character> leftChars = new LinkedList<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '[' ){
                leftChars.addFirst(c);
            } else {
                if (leftChars.isEmpty()){
                    return false; // invalid right char
                }

                if ((c == ')' && leftChars.peekFirst() != '(') || (c == ']' && leftChars.peekFirst() != '[') || (c == '}' && leftChars.peekFirst() != '{')) {
                    return false;
                }
                leftChars.removeFirst();
            }
        }
        return leftChars.isEmpty();
    }
}

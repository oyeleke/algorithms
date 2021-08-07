package elements_of_programming_interviews;

import java.util.Deque;
import java.util.LinkedList;

public class IsWellFormed {

    public static boolean isWellFormed(String s) {
        Deque<Character> characterList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                characterList.addFirst(s.charAt(i));
            } else {
                if (characterList.isEmpty()) {
                    return false;
                }

                if (s.charAt(i) == ')' && characterList.peekFirst() != '(' || s.charAt(i) == '}' && characterList.peekFirst() != '{' ||
                        s.charAt(i) == ']' && characterList.peekFirst() != '[') {
                    return false;
                }
                characterList.removeFirst();
            }
        }
        return characterList.isEmpty();
    }

    public static void main(String[] args) {
        System.out.print(isWellFormed("[()[]()()]"));
    }
}

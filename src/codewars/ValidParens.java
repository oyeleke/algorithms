package codewars;

import java.util.HashSet;
import java.util.Stack;

import org.junit.Test;

import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

public class ValidParens {

    public static boolean validParentheses(String parens) {
        //Put code below
        if (parens.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        HashSet<Character> opening = new HashSet<>();
        opening.add('(');


        for (int i = 0; i < parens.length(); i++) {
            if (parens.charAt(i) == ')' || parens.charAt(i) == '(') {
                if (opening.contains(parens.charAt(i))) {
                    stack.push(parens.charAt(i));
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        System.out.println("popped");
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean validParentheses2(String parens)
    {
        int stack = 0;
        for(char c : parens.toCharArray())
        {
            if (c == '(')
                ++stack;
            else if (c == ')')
            {
                if (stack == 0)
                    return false;
                else
                    --stack;
            }
        }

        return stack == 0;
    }

    public static void main(String[] args) {
        System.out.println(ValidParens.validParentheses("())"));
    }

    @Test
    public void sampleTest() {
        assertTrue(ValidParens.validParentheses("()"));
        assertFalse(ValidParens.validParentheses("())"));
        assertTrue(ValidParens.validParentheses( "32423(sgsdg)" ));
        assertFalse(ValidParens.validParentheses( "(dsgdsg))2432" ));
        assertTrue(ValidParens.validParentheses( "adasdasfa" ));
    }
}

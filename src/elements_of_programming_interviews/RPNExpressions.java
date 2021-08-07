package elements_of_programming_interviews;

import java.util.Deque;
import java.util.LinkedList;

public class RPNExpressions {
    public static int eval(String rPNExpression) {
        Deque<Integer> intermediateResults = new LinkedList<>();
        String delimiter = ",";
        String[] tokens = rPNExpression.split(delimiter);
        String operations = "+-*/";
        for (String token : tokens) {
            if (token.length() == 1 && operations.contains(token)) {
                int x = intermediateResults.removeFirst();
                int y = intermediateResults.removeFirst();
                switch (token.charAt(0)) {
                    case '+':
                        intermediateResults.addFirst(x + y);
                        break;
                    case '-':
                        intermediateResults.addFirst(x - y);
                        break;
                    case '*':
                        intermediateResults.addFirst(x * y);
                        break;

                    case '/':
                        intermediateResults.addFirst(x / y);
                        break;

                    default:
                        throw new IllegalArgumentException("Malformed RPN at :" + token);
                }
            } else {
                intermediateResults.addFirst(Integer.parseInt(token));
            }
        }
        return intermediateResults.removeFirst();
    }

    public int evalRPN(String[] tokens) {

        int top = 0, curr = 1;

        while (curr < tokens.length) {
            if (isOperator(tokens[curr])) {
                int m = Integer.parseInt(tokens[top - 1]);
                int n = Integer.parseInt(tokens[top]);
                int c = applyOperator(m, n, tokens[curr].charAt(0));

                tokens[--top] = String.valueOf(c);
            } else {
                tokens[++top] = tokens[curr];
            }
            curr++;
        }

        return Integer.parseInt(tokens[0]);

    }

    private boolean isOperator(String x) {
        return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/");
    }

    private int applyOperator(int x, int y, char op) {
        if (op == '+') return x + y;
        else if (op == '-') return x - y;
        else if (op == '*') return x * y;
        else if (op == '/') return x / y;

        return 0;
    }
}

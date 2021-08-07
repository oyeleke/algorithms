package algoerxpertss.stacks;

import java.util.ArrayList;

public class SortStacks {
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // Write your code here.
        return sort(stack);
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> stack){
        if (stack.isEmpty()){
            return stack;
        }

        int top = pop(stack);

        sort(stack);

        insert(stack, top);

        return stack;
    }

    public static void insert(ArrayList<Integer> stack, int value){
        if (stack.isEmpty() || stack.get(stack.size() - 1) <= value){
            append(stack, value);
            return;
        }

        int top = pop(stack);

        insert(stack, value);

        append(stack, top);
    }

    public static int pop(ArrayList<Integer> stack){
        return stack.remove(stack.size()-1);
    }

    public static void append(ArrayList<Integer> stack, int value){
        stack.add(value);
    }
}

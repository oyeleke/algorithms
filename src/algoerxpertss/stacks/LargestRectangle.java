package algoerxpertss.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {
    public static int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {

        if (buildings.size() == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < buildings.size(); i++){
            int start = -1;
            int end = -1;
            // get indices we can get buildings up to
            for (int j = i-1; j >= 0; j--){
                if (buildings.get(j) < buildings.get(i)){
                    break;
                }
                start = j;
            }

            for ( int k = i+1; k< buildings.size(); k++
            ){
                if (buildings.get(k) < buildings.get(i)){
                    break;
                }

                end = k;
            }

            if (start == -1){
                start = i;
            }

            if (end == - 1){
                end = i;
            }
            int total = end - start + 1;

            max = Math.max(max, (total * buildings.get(i)));
        }
        // Write your code here.
        return max;
    }

    public static int largestRectangleUnderSkylines(ArrayList<Integer> buildings) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        buildings.add(0);
        for (int i =0; i< buildings.size(); i++){
            while (!stack.isEmpty() && buildings.get(stack.peek()) >= buildings.get(i)){
                int height = buildings.get(stack.pop());
                int width =  (stack.isEmpty() ? i : (i - stack.peek()) - 1);
                System.out.println("Height: "+height + " Width: "+ width);
                max = Math.max(max, (width * height));
            }

            stack.push(i);
        }
        return max;
    }

        public static void main(String[] args) {
        int [] array = new int[] {1, 2, 3, 4, 5};
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int text:array) {
            list2.add(text);
        }
        System.out.print(largestRectangleUnderSkylines(list2));
    }
}

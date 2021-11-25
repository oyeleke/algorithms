package hackerrank.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    public static long largestRectangle(List<Integer> h) {
        // Write your code here
        Stack<Integer>buildingIndex = new Stack<>();
        long max = 0;
        h.add(0);
        List<Long> longs = new ArrayList<>(h.size());
        for (int i=0;i<h.size();++i) {
            longs.add(h.get(i).longValue());
        }
        for (int i = 0; i < h.size(); i++){

            while(!buildingIndex.isEmpty() && longs.get(buildingIndex.peek()) >= longs.get(i)){
                long height = longs.get(buildingIndex.pop());
                long width = buildingIndex.isEmpty() ? i : (i - buildingIndex.peek()) - 1;
                max = Math.max(max, (height * width));
            }

            buildingIndex.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.print(largestRectangle(list));
    }
}

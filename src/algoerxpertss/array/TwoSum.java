package algoerxpertss.array;

import java.util.*;

public class TwoSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer, Integer>map = new HashMap<>();
        int [] result = new int[2];
        for (int k : array) {
            int sub = targetSum - k;

            if (map.containsKey(k)){
                result[0] = k;
                result[1] = sub;
                return result;
            }
            map.put(sub, k);
        }

        return new int[0];
    }

    public static void main(String [] args){
        int [] array = new int []{3, 5, -4, 8, 11, 1, -1, 6};
        int [] result = twoNumberSum(array, 10);
        for(int j : result){
            System.out.println(j);
        }
    }
}

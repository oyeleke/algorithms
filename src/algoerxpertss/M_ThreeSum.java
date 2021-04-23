package algoerxpertss;

import java.util.*;


public class M_ThreeSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        ArrayList<Integer[]> result = new ArrayList<>();
        if(array.length < 3){
            return result;
        }
        Arrays.sort(array);
        for (int n = 0; n < array.length - 2; n++) {
            int sum = targetSum - array[n];
            int a = n+1, end = array.length - 1;
            while (end > a) {

                if (array[a] + array[end] == sum) {
                    result.add(new Integer []{array[n], array[a], array[end]});
                    end--;
                    a++;
                } else if(array[a] + array[end] > sum){
                    end --;
                } else if(array[a] + array[end] < sum) {
                    a++ ;
                }
            }
        }
        return result;
    }
}

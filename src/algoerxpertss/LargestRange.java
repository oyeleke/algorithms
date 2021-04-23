package algoerxpertss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        if(array.length == 1){
            return new int[] {array[0], array[0]};
        }
        if(array.length == 2){
            if(array[0] < array[1]){
                return new int[] {array[0], array[1]};
            }else {
                return new int[] {array[0], array[0]};
            }
        }
        Arrays.sort(array);
        int rangeStart = array[0];
        int rangeEnd = 0;
        int [] result = new int[]{};
        ArrayList<int[]> arrayList = new ArrayList<>();
        int largest = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++){
            int j = i, start = i, end = -1, currentLargestRange = 0;
            while( j < array.length){
                if(array[j-1]+ 1 == array[j] || array[j-1] == array[j]){
                    end = j;
                    if(array[j-1] != array[j]){
                        currentLargestRange++;
                    }
                    if(currentLargestRange > largest){
                        largest = currentLargestRange;
                        result = new int[]{array[start-1], array[end]};
                    }
                } else {
                    break;
                }
                j++;
            }
        }

        return result;
    }

    public static int[] largestRange2(int[] array) {
        int [] result = new int[2];
        HashMap<Integer, Boolean> map = new HashMap<>();
        int longest = Integer.MIN_VALUE;
        for(int n: array){
            map.put(n, true);
        }

        for(int n: array){
            if(!map.get(n)){
                continue;
            }
            int currentLongestRange = 0;
            int left = n-1;
            int right = n+1;
            while(map.containsKey(left)){
                map.put(left, false);
                currentLongestRange++;
                left--;
            }
            while(map.containsKey(right)){
                map.put(right, false);
                currentLongestRange++;
                right++;
            }
            if(currentLongestRange > longest){
                longest = currentLongestRange;
                result = new int[]{left+1, right-1};
            }

        }
        // Write your code here.
        return result;
    }
}

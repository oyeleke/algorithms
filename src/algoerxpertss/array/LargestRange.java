package algoerxpertss.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        if(array.length == 1){
            return new int[] {array[0], array[0]};
        }
        Arrays.sort(array);

        if(array.length == 2){
            return new int[] {array[0], array[1]};
        }
        int [] result = new int[]{};
        int largest = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++){
            int j = i, currentLargestRange = 0;
            while( j < array.length){
                if(array[j-1]+ 1 == array[j] || array[j-1] == array[j]){
                    if(array[j-1] != array[j]){
                        currentLargestRange++;
                    }
                    if(currentLargestRange > largest){
                        largest = currentLargestRange;
                        result = new int[]{array[i-1], array[j]};
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

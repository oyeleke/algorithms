package algoerxpertss;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifferenceFast(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int one = 0, two = 0;
        int oneF = -1, twoF = -1;
        int smallest = Integer.MAX_VALUE;
        while(one < arrayOne.length && two < arrayTwo.length){
            int diff = Math.abs(arrayOne[one] - arrayTwo[two]);
            if(diff == 0){
                return new int[] {arrayOne[one], arrayTwo[two]};
            }
            if (diff < smallest){
                smallest = diff;
                oneF = one;
                twoF = two;
            }
            if(arrayOne[one] < arrayTwo[two]){
                one++;
            } else {
                two++;
            }
        }
        return new int[] {arrayOne[oneF], arrayTwo[twoF]};
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int smallest = Integer.MAX_VALUE;
        int array1 = 0;
        int array2 = 0;
        for(int i = 0; i< arrayOne.length; i++){
            for(int j = 0; j < arrayTwo.length; j++){
                if(Math.abs(arrayTwo[j] - arrayOne[i]) < smallest){
                    smallest = Math.abs(arrayTwo[j] - arrayOne[i]);
                    array1 = arrayOne[i];
                    array2 = arrayTwo[j];
                }
            }
        }
        return new int[] {array1, array2};
    }
}

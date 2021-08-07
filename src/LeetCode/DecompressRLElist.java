package LeetCode;

import java.util.Arrays;

public class DecompressRLElist {
    public int[] decompressRLElist(int[] nums) {
        if (nums.length == 0 || nums == null){
            return new int[]{};
        }
        // cal size of array;
        int newArraySize = 0;
        for (int i = 0; i < nums.length; i+=2){
            newArraySize += nums[i];
        }

        int [] newArray = new int[newArraySize];
        int k = 0;

        for (int i = 0, j = 1; i < nums.length && j < nums.length; i+=2, j+=2){
            int h = nums[i];
            while (h > 0){
                newArray[k] = nums[j];
                k++;
                h--;
            }
        }

        return newArray;
    }

    public int[] decompressRLElistElegant(int[] nums) {

        int len =0 ;
        for(int i=0;i<nums.length;i+=2){
            len += nums[i];
        }
        int lst[] = new int[len];
        int strIndex =0;

        for(int i=0;i<nums.length;i+=2){

            Arrays.fill(lst,strIndex,strIndex+nums[i],nums[i+1]);
            strIndex += nums[i];
        }
        return lst;
    }
}

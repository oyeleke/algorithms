package LeetCode;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int result = 0;
        if(heights == null || heights.length <= 1){
            return result;
        }
        int [] heightDouble = new int [heights.length];
        for (int i = 0; i < heightDouble.length; i++){
            heightDouble[i] = heights[i];
        }
        Arrays.sort(heightDouble);

        for (int i = 0; i< heightDouble.length; i++){
            if (heightDouble[i] != heights[i]){
                result++;
            }
        }
        return result;
    }

    public int heightChecker2(int[] heights) {
        int  [] heightFreq  = new int[101];
        int result = 0;
        for (int height: heights){
            heightFreq[height]++;
        }
        int curheight = 0;

        for (int i = 0; i < heights.length; i++){

            while(heightFreq[curheight] == 0){
                curheight++;
            }

            if (curheight != heights[i]){
                result++;
            }

            heightFreq[curheight]--;
        }
        return result;
    }
    }

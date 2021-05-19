package algoerxpertss.array;

import java.util.*;

public class MinRewards {

    public static int minRewards(int[] scores) {
        // Write your code here.

        int result = 0;
        int [] resultArray = new int[scores.length];
        Arrays.fill(resultArray, 1);

        for (int n = 1 ; n < scores.length; n++){
            if (scores[n] > scores[n-1]){
                resultArray[n] = Math.max(resultArray[n], resultArray[n-1]+1);
            }
        }

        for (int n = scores.length-2; n >= 0; n--){
            if(scores[n] > scores[n+1]){
                resultArray[n] =  Math.max(resultArray[n], resultArray[n+1]+1);
            }
        }

        for(int n: resultArray){
            result += n;
        }
        return result;
    }
}

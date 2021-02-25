package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Transpose2dArray {
    public int[][] transpose(int[][] A) {
         int [] [] newA = new int[A[0].length][A.length];

         for (int i = 0; i < A.length; i++){
             for (int j = 0; j < A[0].length; j++){
                 newA[j][i] = A[i][j];
             }
         }

        return newA;
    }

}

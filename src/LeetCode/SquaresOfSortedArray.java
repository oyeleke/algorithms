package LeetCode;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int [] result = new int[n];
        int p = 0, q = n-1;
        for(int j = n-1 ; j >= 0; j--){
            if(Math.abs(A[p]) > Math.abs(A[q])){
                result[j] = A[p] * A[p];
                p++;
            } else {
                result[j] = A[q] * A[q];
                q--;
            }
        }

        return result;
    }
}

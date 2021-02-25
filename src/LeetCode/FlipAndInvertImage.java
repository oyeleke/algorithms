package LeetCode;

public class FlipAndInvertImage {
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {

            for(int i = 0; i < A.length; i++){
                reverseArray(A[i]);
            }

            for(int i = 0; i < A.length; i++){

                for(int j = 0 ; j < A.length; j++){
                    if (A[i][j] == 0){
                        A[i][j] = 1;
                    }else if(A[i][j] == 1){
                        A[i][j] = 0;
                    }
                }
            }
            return A;
        }

        public void reverseArray(int [] A){
            int start = 0;
            int end = A.length - 1;
            int mid = A.length/2;
            for (int i = 0; i< mid; i++){
                swap(start++, end--, A);
            }
        }


        public void swap(int a, int b, int [] A){
            int temp = A[a];
            A[a] = A[b];
            A[b] = temp;
        }
    }
}

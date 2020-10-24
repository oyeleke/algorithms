package codility;

public class CodilityMaxDoubleSlice {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int []maxSumForeward = new int[A.length];
        int []maxSumBackword = new int[A.length];

        for (int i =1; i<A.length; i++){
            maxSumForeward[i] = Math.max(maxSumForeward[i-1] + A[i], A[i]);
        }

        for (int i = A.length -2; i > 0; i--){
            maxSumBackword[i] = Math.max(maxSumBackword[i+1] + A[i], 0);
        }

        int maxSubarray = 0;

        for (int i =1; i<A.length-1; i++){
            maxSubarray = Math.max(maxSumBackword[i + 1]+maxSumForeward[i-1], maxSubarray);
        }

        return maxSubarray;
    }
}

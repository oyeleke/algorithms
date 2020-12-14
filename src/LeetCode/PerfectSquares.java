package LeetCode;

import educative.sorting_and_searching.Helper;

import java.util.Arrays;

public class PerfectSquares {

    public static int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, n);

        if(n < 4){
            return n;
        }

        dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 3;

        for(int i = 4; i<= n; i++){
            for(int j = 1; j*j <= i; j++){

                dp[i] = Math.min(dp[i], dp[i - j*j]+1);

            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = numSquares(8);
    }

    protected boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public int numSquaresTheorem(int n) {
        // four-square and three-square theorems.
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        if (this.isSquare(n))
            return 1;
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i))
                return 2;
        }
        // bottom case of three-square theorem.
        return 3;
    }
}

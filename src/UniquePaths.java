
import java.math.BigInteger;
import java.util.Scanner;

class Solution {
    public  int uniquePaths(int m, int n) {
        int d = m + n - 2;
        int r = n - 1;
        BigInteger denom = factorial(d-r).multiply(factorial(r));
        BigInteger up = factorial(d).divide(denom);
        return Integer.valueOf(up.toString());
    }

    static BigInteger factorial(int n){ return bigIntfactorial(new BigInteger(String.valueOf(n))); }


    static BigInteger bigIntfactorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(bigIntfactorial(n.subtract(BigInteger.ONE)));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        //System.out.println(uniquePaths(m, n));


        scanner.close();
    }
}

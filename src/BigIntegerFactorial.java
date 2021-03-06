import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerFactorial {
    static BigInteger factorial(BigInteger n) {
        Integer.valueOf(n.toString());
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        System.out.println(factorial(new BigInteger(String.valueOf(n))));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}

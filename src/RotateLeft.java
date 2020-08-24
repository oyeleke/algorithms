import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RotateLeft {
    private static final Scanner scanner = new Scanner(System.in);
    private Map<String, Integer> testMap = new HashMap<>();
    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        scanner.close();

        int[] rotatedArray = rotateArray(a,d);

        for(int i = 0; i < rotatedArray.length; i++){
            System.out.print(rotatedArray[i]+" ");
        }
    }

    static int[] rotateArray(int[] a, int d){
        for(int i = 0; i < d; i++){
            int first, j;
            first = a[0];
            for(j = 0; j < a.length - 1; j++){
                a[j] = a[j+1];
            }
            a[j] = first;
        }
        return a;
    }

    static int[] rotateArray(int[] a, int d, int n){
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            int index = i - d;
            if (index < 0){
                index = n + index;
            }
            b[index] = a[i];
        }
        return b;
    }

}

package hackerrank.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int n = a.size();
        int swapCount = 0;

        if (n == 1) {
            System.out.println("Array is sorted in " + 0 + " swaps.");
            System.out.println("First Element: " + a.get(0));
            System.out.println("Last Element: " + a.get(0));
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                if (a.get(j) > a.get(j + 1)) {
                    swap(j, j+1, a);
                    swapCount++;
                }
            }
        }

        System.out.println("Array is sorted in " + swapCount + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(n - 1));
    }

    public static void swap(int i, int j, List<Integer> a) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public static void main(String[] args) {
        countSwaps(Arrays.asList(3, 2, 1));
    }

}

package educative.sorting_and_searching;

import java.util.Arrays;

class Median {
    public static double getMedian(int array1[], int array2[]) {
        int[] combined = new int[(array1.length ) + (array2.length ) ];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < array1.length && j < array2.length){
            if (array1[i] <= array2[j]){
                combined[k] = array1[i];
                i++;
            } else {
                combined[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i < array1.length){
            combined[k] = array1[i];
            i++;
            k++;
        }

        while (j < array2.length){
            combined[k] = array2[j];
            j++;
            k++;
        }

        int mid = combined.length /2;
        double result = 0;

        if (combined.length % 2 == 0){
            result = (Double.valueOf(combined[mid - 1]) + Double.valueOf(combined[mid])) / 2;
        } else {
            result = combined[mid];
        }

        return result;
    }

    public static void main(String args[]) {
        int array1[] = {
                5,
                8,
                10,
                11,
                20
        };
        int array2[] = {
                900
        };

        System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + getMedian(array1, array2));

        // Example 2
        int array3[] = {
                1,
                2,
                3,
                4,
                5
        };
        int array4[] = {
                100,
                200,
                300,
                400
        };

        System.out.println("The median of " + Arrays.toString(array3) + " and " + Arrays.toString(array4) + " is " + getMedian(array3, array4));
    }
}
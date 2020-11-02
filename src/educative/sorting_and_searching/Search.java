package educative.sorting_and_searching;

import java.util.Arrays;

class Search {
    static int binarySearch(int s, int arr[], int arrSize) {
        if (arrSize <= 0) return -1;
        if (arrSize == 1) {
            if (s == arr[0]) {
                return 0;
            } else return -1;
        }

        int start = 0;
        int end = arrSize - 1;
        int mid;
        while (start <= end) {
            System.out.println(start + " " + end);
            mid = (start + end) / 2;
            if (s > arr[mid]) {
                start = mid + 1;
            } else if (s < arr[mid]) {
                end = mid - 1;
            } else return mid;
        }
        //write-your-code-here
        return -1;
    }

    static int binarySearchdynamic(int s, int arr[], int arrSize, int start, int end) {
        if (arrSize <= 0) return -1;
        if (arrSize == 1) {
            if (s == arr[0]) {
                return 0;
            } else return -1;
        }


        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (s > arr[mid]) {
                start = mid + 1;
            } else if (s < arr[mid]) {
                end = mid - 1;
            } else return mid;
        }
        //write-your-code-here
        return -1;
    }


    // Driver code to test the function
    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 410, 5, 95, 4, -100, 20, 0};
        int arrSize = 10;
        int key = 1;
        Arrays.sort(arr);
        int index = binarySearch(key, arr, arrSize);
        Helper obj = new Helper();
        obj.printArray(arr, arrSize);
        if (index != -1)
            System.out.println("Your Key \"" + key + "\" is found at index \"" + index + "\"");
        else
            System.out.println("Your Key \"" + key + "\" not found in the array: ");

    }
}


package educative.sorting_and_searching;

import static educative.sorting_and_searching.Search.binarySearchdynamic;

class CheckSum {
    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];
        for(int i = 0; i< arr.length; i++){
            int second = n - arr[i];
            //System.out.println(second);
            if(binarySearchdynamic(second, arr, arr.length, 0, arr.length-1) != -1){
                result[0] = arr[i];
                result[1] = second;
                break;
            }
        }
        return result; // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static void main(String args[]) {

        int n = 81;
        int[] arr1 = {1,21,3,14,5,60,7,6};
        int[] arr2 = findSum(arr1, n);
        int num1 = arr2[0];
        int num2 = arr2[1];

        if ((num1 + num2) != n)
            System.out.println("Results not found!");
        else
            System.out.println("Sum of " + n + " found: " + num1 + " and " + num2);
    }
}

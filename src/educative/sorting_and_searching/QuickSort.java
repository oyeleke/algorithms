package educative.sorting_and_searching;

import java.util.Random;

public class QuickSort {

    //to choose a pivot and ensure its not on the left
    private static int choosePivot(int left, int right){
        Random rand = new Random();

        System.out.println("left "+ left + " right "+ right);

        int i1 = left + rand.nextInt((right-left+1));
        int i2 = left + rand.nextInt((right-left+1));
        int i3 = left + rand.nextInt((right-left+1));

        return Math.max(Integer.min(i1, i2), Math.min(Math.max(i1, i2), i3));
    }

    //this is where we sort through using the pivots
    private static int partition (int[] arr, int left, int right){
        int pivotId = choosePivot(left, right);
        int pivot = arr[pivotId];
        System.out.println("left "+ left +" pivot "+ pivot + " right "+ right);
        Helper.swap(arr, pivotId, right);
        int i = left - 1;
        System.out.println(" i before for "+ i + " j "+ right);

        //moving all values less than the pivot to i or before i
        for (int j = left; j< right-1; j++){
            if (arr[j] <= pivot){
                i++;
                System.out.println(" i "+ i + " j "+ j);
                Helper.swap(arr, i, j);
            }
        }
        //swap pivot back to original position
        Helper.swap(arr, i+1, right);
        return i+1;
    }

    private static void quickSort(int [] arr, int left, int right){

        if (left < right){
            int p = partition(arr, left, right);

            quickSort(arr, left, p-1);
            quickSort(arr, p+1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        quickSort(arr, 0, arrSize - 1);
        System.out.print("Sorted array: ");
        Helper.printArray(arr, arrSize);
    }
}

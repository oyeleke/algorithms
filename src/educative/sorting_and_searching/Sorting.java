package educative.sorting_and_searching;

public class Sorting {

    static Helper obj = new Helper();
    public static void selectionSort(int [] arr, int arraySize){
        int minId;

        for (int i = 0; i < arraySize; i++){

            minId = obj.findMin(arr, i, arraySize-1);

            int temp = arr[i];
            arr[i] = arr[minId];
            arr[minId] = temp;
        }
    }

    public static void bubbleSort(int[] arr, int arraySize){
        for (int i = 0; i < arraySize - 1; i++){
            for (int j = 0; j< arraySize -i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr, int arraySize){

        for (int i = 1; i< arraySize; i++){
            int ele = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > ele){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = ele;
        }
    }



    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        insertionSort(arr, arrSize);
        obj.printArray(arr, arrSize);
    }
}

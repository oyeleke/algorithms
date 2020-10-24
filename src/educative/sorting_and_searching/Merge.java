package educative.sorting_and_searching;



public class Merge {

    public static void merge(int[] arr, int left, int mid, int right) {
        int leftArrSize = mid - left + 1;
        int rightArrSize = right - mid;

        int[] leftArr = new int [leftArrSize];
        int[] rightArr = new int[rightArrSize];
        if (leftArrSize >= 0) System.arraycopy(arr, left, leftArr, 0, leftArrSize);
        if (rightArrSize >= 0) System.arraycopy(arr, mid + 1, rightArr, 0, rightArrSize);

        //this is where the real algo is
        int i = 0, j = 0, k = left;
        Helper obj = new Helper();
        System.out.println("left arr size"+ leftArrSize +" right arr size"+ rightArrSize);
        System.out.print("left arr ");
        obj.printArray(leftArr, leftArrSize);

        System.out.print("right arr ");
        obj.printArray(rightArr, rightArrSize);

        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        //put remainder of the left array in k if theres any
        while (i < leftArrSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArrSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        obj.printArray(arr, arr.length);

        System.out.println("");


    }

    public static void mergeSort(int[] arr, int left, int right) {
        //sanity checks
        if (left < 0 || right < 0)
            return;


        if (right > left) {
            int mid = left + (right - left) / 2; // to prevent overflow
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            System.out.println(left + " "+ mid+ " "+ right + " ");
            merge(arr, left, mid, right);

        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 0, 5, 95, 4, -100, 200, 0};
        int arrSize = 10;
        mergeSort(arr, 0, arrSize - 1);
        Helper obj = new Helper();
        obj.printArray(arr, arrSize);
    }
}

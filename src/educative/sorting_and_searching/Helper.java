package educative.sorting_and_searching;

public class Helper {

    public static int findMin(int []a, int start, int end){
        if (end <=0 || start < 0)
            return 0;
        int mInd = start;
        for (int i = start+1; i <= end; i++){
            if (a[mInd] > a[i]){
                mInd = i;
            }
        }
        return mInd;
    }

    static void printArray(int[] arr, int arrSize) {
        for (int i = 0; i < arrSize; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

package LeetCode;

public class ParitySort {

    public int[] paritySort2(int[] A) {

        int ptrToRead = 0, ptrToWrite = 0;

        for (; ptrToRead < A.length; ) {
            if (A[ptrToRead] % 2 != 0) {
                ptrToRead++;
            } else {
                int temp = A[ptrToRead];
                A[ptrToRead] = A[ptrToWrite];
                A[ptrToWrite] = temp;
                ptrToRead++;
                ptrToWrite++;
            }
        }

        return A;
    }

    public int[] sortArrayByParity(int[] A) {
        if(A.length <= 1){
            return A;
        }
        int j = 0;
        for(int i = 0; i< A.length; i++){
            if(isEven(A[j]) && !isEven(A[i])){
                j = i;
            }

            if(!isEven(A[j]) && isEven(A[i])){
                swap(A, j, i);
                j++;
            }
        }

        return A;
    }

    public boolean isEven(int a){
        return a % 2 == 0;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}

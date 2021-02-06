package LeetCode;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(!(nums.length == 1)){
            int n = nums.length;
            int k = n-2;

            while( k >= 0 && nums[k] >= nums[k+1] ){
                --k;
            }

            if(k == -1){
                reverseArray(0, n-1, nums);
            } else {

                for(int j = n-1; j > k; j--){
                    if(nums[j] > nums[k]){

                        swap(j, k, nums);
                        break;
                    }
                }
                int y = n-1;
                int h = k+1;
                if(y - h == 1){
                    swap(y, h, nums);
                }else {
                    reverseArray(h, y, nums);
                }
            }
        }
    }

    public void reverseArray(int start, int end, int [] A){
        int mid = ((end - start)+ 1)/2;
        for(int i = 0; i< mid; i++){
            swap(start++, end--, A);
        }
    }


    public void swap(int a, int b, int [] A){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}

package LeetCode;

public class MoveZeros {

    public void moveZeros2(int [] n){
        int c = 0;
        for (int i =0; i< n.length; i++){
            if (n[i] != 0){
                n[c] = n[i];
                c++;
            }
        }

        for (int i = c; i< n.length; i++){
            n[i] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        int j = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[j] != 0 && nums[i] == 0){
                j = i;
            }

            if(nums[j] == 0 && nums[i] != 0){
                swap(nums, j, i);
                j++;
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

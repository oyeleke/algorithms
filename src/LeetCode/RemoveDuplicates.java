package LeetCode;

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 0) return 0;
        if (nums.length == 1) return 1;
        int j=0;
        for(int i = 0; i< nums.length; i++){
            if(nums[j] != nums[i] && i-j == 1){
                j++;
            } else if(nums[j] != nums[i] && i-j > 1 ) {
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        return j+1;
    }
}

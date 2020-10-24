package LeetCode;

public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int single = -1;
        if(nums.length <= 2){
            return nums[0];
        }

        for(int i = 1; i< nums.length; i+=2){
            if(nums[i-1] != nums[i]){
                single = nums[i-1];
                break;
            }
        }

        if(single < 0){
            single = nums[nums.length - 1];
        }
        return single;
    }
}

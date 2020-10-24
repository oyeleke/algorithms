package LeetCode;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValue {
    public int minDifference(int[] nums) {
        if(nums.length <= 4 ){
            return 0;
        } else {
            Arrays.sort(nums);
            int min = Integer.MAX_VALUE;
            int len = nums.length;
            min = Integer.min(min, (nums[len - 4] - nums[0]));
            min = Integer.min(min, (nums[len-3] - nums[1]));
            min = Integer.min(min, (nums[len-2] - nums[2]));
            min = Integer.min(min, (nums[len-1] - nums[3]));
            return min;
        }

    }
}

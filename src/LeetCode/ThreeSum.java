package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length <= 2){
            return result;
        }
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++ ){
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){

                int low = i+1;
                int high = nums.length - 1;
                int sum = -nums[i];
                while(high > low){
                    if (nums[high] + nums[low] == sum){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(high > low && nums[low] == nums[low + 1])low++;
                        while(high > low && nums[high] == nums[high - 1])high--;
                        low++;
                        high--;
                    } else if (nums[high] + nums[low] > sum){
                        high --;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}

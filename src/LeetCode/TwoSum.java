package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashSet = new HashMap<>();
        int result [] = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (hashSet.containsKey(target - nums[i])){
                result[0] = nums[i];
                result[1] = hashSet.get(target - nums[i]);
                return result;
            }
            hashSet.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}

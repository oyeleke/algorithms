package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KDiffPairs {
    public int findPairsSlow(int[] nums, int k) {
        int count = 0;
        Set<Integer> addedNumbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k){
                    if (addedNumbers.add(nums[i] + nums[j])){
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public int findPairs(int[] nums, int k) {
        int right = 0, left = 0, count = 0;
        Arrays.sort(nums);
        while (left < nums.length && right < nums.length){
            if (left == right || Math.abs(nums[right] - nums[left]) < k){
                right++;
            } else if(Math.abs(nums[right] - nums[left]) > k){
                left++;
            } else {
                left++;
                while (left < nums.length && nums[left] == nums[left - 1]){
                    left++;
                }
                count++;
            }
        }
        return count;
    }
    }

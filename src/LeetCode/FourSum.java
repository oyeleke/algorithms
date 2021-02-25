package LeetCode;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> set = new HashSet<>();

        List<List<Integer>> result = new LinkedList<>();
        if (nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        for (int j = 0; j < nums.length - 3; j++) {
            int newTarget = target - nums[j];
            for (List<Integer> list : threeSum(nums, j + 1, newTarget)) {
                //list.add(nums[j]);
                List<Integer> newList = new LinkedList<>();
                newList.add(nums[j]);
                newList.addAll(list);
                set.add(newList);
            }
        }

        result.addAll(set);

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int newTarget) {
        List<List<Integer>> result = new LinkedList<>();

        for (int i = start; i < nums.length - 2; i++) {

            int low = i + 1;
            int high = nums.length - 1;
            int sum = newTarget - nums[i];
            while (high > low) {
                if (nums[high] + nums[low] == sum) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (high > low && nums[low] == nums[low + 1]) low++;
                    while (high > low && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[high] + nums[low] > sum) {
                    high--;
                } else {
                    low++;
                }
            }

        }
        System.out.println(result);
        return result;
    }
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size; ++i){
            for (int j = i+1; j < size; ++j){
                int left = j + 1;
                int right = size - 1;

                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        int leftValue = nums[left];
                        while(left < size && nums[left] == leftValue){
                            left++;
                        }

                        int rightValue = nums[right];
                        while(right < size && nums[right] == rightValue ){
                            --right;
                        }
                    } else if (sum > target){
                        --right;
                    } else {
                        ++left;
                    }
                } while (j+1 < size && nums[j] == nums[j +1]){
                    ++j;
                }
            } while (i+1 < size && nums[i] == nums[i + 1]){
                ++i;
            }
        }

        return res;
    }

}


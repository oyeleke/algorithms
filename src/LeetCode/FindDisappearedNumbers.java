package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int [] numsCheck = new int [nums.length+1];

        for(int n : nums){
            if(n <= nums.length){
                numsCheck[n]++;
            }
        }

        for(int i = 0; i < numsCheck.length; i++){
            if(numsCheck[i] == 0 && i != 0){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {

        for (int i = 0; i < nums.length; i++){
            int value = Math.abs(nums[i]) - 1;
            if (nums[value] > 0){
                nums[value] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int n : nums){
            if (n > 0){
                result.add(n+1);
            }
        }


        return result;
    }
}

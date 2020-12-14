package LeetCode;


import java.util.HashMap;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        if(nums.length == 1){
            if(nums[0] == val) return 0;
            else return 1;
        }
        int j = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[j] != val && nums[i] == val){
                j = i;
            }
            HashMap<Integer, Integer>keeps = new HashMap<>();
            keeps.put(1, (keeps.get(1) != null ? keeps.get(1) + 1 : 0));
            keeps.get(1);
            if(nums[j] == val && nums[i] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }

        }
        if (j == 0 && nums[j] != val){
            j = nums.length;
        }
        return j;
    }
}

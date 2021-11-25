package LeetCode;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int reStartIndex = 0;
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];

            while(reStartIndex <= i && sum - nums[target] >= target){
                sum -= nums[target];
                reStartIndex++;
            }

            if(res > i-reStartIndex+1){
                res = i-reStartIndex+1;
            }
        }


        return res != Integer.MAX_VALUE ? res : 0;
    }


    public static void main(String[] args) {
        MinimumSizeSubarraySum sum = new MinimumSizeSubarraySum();
        System.out.print(sum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

}

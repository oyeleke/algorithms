package LeetCode;

public class JumpGame2 {
    public int jump(int[] nums) {
        int furthestReachSoFar = nums[0], n = nums.length;
        int minSteps = 1;
        if(n == 1 || nums[0] == 0 ){
            return 0;
        }

        int currentEnd = nums[0];

        for (int i = 1; i < n; ++i){
            if(i == n-1){
                return minSteps;
            }

            furthestReachSoFar = Math.max(furthestReachSoFar, i + nums[i]);
            if (i == currentEnd){
                currentEnd = furthestReachSoFar;
                minSteps++;
            }
        }

        return minSteps;
    }
}

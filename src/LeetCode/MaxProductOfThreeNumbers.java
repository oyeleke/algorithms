package LeetCode;

import java.util.Arrays;

public class MaxProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int result = 0;
        int lastIndex = nums.length - 1;
        int[] newArray = new int[6];

        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);

        if (nums[lastIndex] < 0 || nums[0] >= 0) {
            result = nums[lastIndex] * nums[lastIndex - 1] * nums[lastIndex - 2];
        } else {
            if (nums.length <= 6) {
                newArray = nums;
            } else {
                newArray[0] = nums[0];
                newArray[1] = nums[1];
                newArray[2] = nums[2];
                newArray[3] = nums[lastIndex - 2];
                newArray[4] = nums[lastIndex - 1];
                newArray[5] = nums[lastIndex];
            }
            int nLastIndex = newArray.length - 1;
            int first = newArray[0] * newArray[1] * newArray[nLastIndex];
            int second = newArray[nLastIndex - 2] * newArray[nLastIndex - 1] * newArray[nLastIndex];
            if (second > first) {
                result = second;
            } else {
                result = first;
            }
        }

        return result;
    }

    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }

            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}

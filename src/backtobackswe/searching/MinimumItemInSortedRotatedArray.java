package backtobackswe.searching;

import java.util.Arrays;

public class MinimumItemInSortedRotatedArray {
    public int findMin(int[] nums) {

        int smallestNo = -1;
        if(! (nums.length > 0)){
            return smallestNo;
        }

        if (nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.min(nums[0], nums[1]);
        }

        int left = 0, right = nums.length - 1;
        int mid;

        while(true) {
            mid = left + ((right - left)/2);

            if (nums[mid] > nums[right]){
                left = mid + 1;
            } else if(nums[mid] < nums[right]){
                right = mid;
            }

            else if (mid == left){
                smallestNo = nums[mid];
                break;
            }
            System.out.println("left " +left + " mid " + mid + " right " + right);
        }

        return smallestNo;
    }

    public static void main(String[] args) {
        MinimumItemInSortedRotatedArray minimumItemInSortedRotatedArray = new MinimumItemInSortedRotatedArray();
        System.out.println("Ans " + minimumItemInSortedRotatedArray.findMin(new int[]{5,6,7,8,9,10,12,13,3}));
    }
}

package LeetCode;

public class SearchRotatedArraySlow {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }

        if(nums.length == 1){
            if(nums[0] == target){
                return true;
            } else {
                return false;
            }
        }

        if (nums.length == 2){
            if(target == nums[0] || target == nums[1]){
                return true;
            } else {
                return false;
            }
        }
        return search(nums, target, 0, nums.length-1);
    }

    public boolean search(int[]nums, int target, int left, int right){
        int mid = (left + right)/2;

        System.out.println(left+" "+ mid+" "+right);

        if(target == nums[mid]){
            return true;
        }

        if(left > right){
            return false;
        }

        if(nums[left] < nums[mid]){ // left subarray is sorted
            if(target >= nums[left] && target < nums[mid]){
                return search(nums, target, left, mid-1);
            } else {
                return search(nums, target, mid+1, right);
            }
        } else if( nums[mid] <  nums[right]){
            if(target > nums[mid] && target <= nums[right]){
                return search(nums, target, mid+1, right);
            } else {
                return search(nums, target, left, mid-1);
            }
        } else if(nums[mid] == nums[left] || nums[mid] == nums[right] ){


            boolean result = search(nums, target, left, mid-1);
            if(result){
                return result;
            } else {
                return  search(nums, target, mid+1, right);
            }

        }
        return false;
    }

    public boolean searchFasterForRotatedArray2(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }

        if(nums.length == 1){
            if(nums[0] == target){
                return true;
            } else {
                return false;
            }
        }

        if (nums.length == 2){
            if(target == nums[0] || target == nums[1]){
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }
}

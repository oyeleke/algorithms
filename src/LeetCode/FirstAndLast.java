package LeetCode;

class FirstAndLast {
    enum SearchType {
        First, Last
    }
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[]{-1, -1};

        int firstOccurrence = binarySearch(nums, target, 0, nums.length-1, SearchType.First);
        if(firstOccurrence == -1){
            return result;
        }

        int lastOccurrence = binarySearch(nums, target, 0, nums.length-1, SearchType.Last);

        result[0] = firstOccurrence;
        result[1] = lastOccurrence;
        return result;
    }

    public int binarySearch(int[] arr, int k, int left, int right, SearchType searchType){

        if (arr.length == 0 || left > right ){
            return -1;
        }

        int mid = left + (right -left)/2;

        if (arr[mid] == k){
            if(searchType == SearchType.First){
                if (isInBounds(arr, mid-1) && arr[mid-1] == arr[mid]){
                    return binarySearch(arr, k, left, mid-1, searchType);
                }
            }

            if(searchType == SearchType.Last){
                if (isInBounds(arr, mid+1) && arr[mid] == arr[mid+1]){
                    return binarySearch(arr, k, mid + 1, right, searchType);
                }
            }

            return mid;
        }
        else if(arr[mid] < k){
            return binarySearch(arr, k, mid+1, right, searchType);
        } else {
            return binarySearch(arr, k, left, mid-1, searchType);
        }
    }

    private  boolean isInBounds(int[] arr, int i) {
        return i < arr.length && i >= 0 ;
    }
}

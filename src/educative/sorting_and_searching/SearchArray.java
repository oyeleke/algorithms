package educative.sorting_and_searching;

class SearchArray {
    static int searchRotatedArray(int arr[], int left, int right, int n) {
        int mid = (left + right)/2;

        System.out.println(left+" "+ mid+" "+right);
        System.out.println(n+ " "+ arr[mid]);

        if (n == arr[mid]){
            System.out.println("got here");
            return mid;
        }

        if (right < left){
            return -1;
        }

        if (arr[left] < arr[mid]){ // if the left side is sorted
            if (n >= arr[left] && n < arr[mid]){ // its in the left side
               return searchRotatedArray(arr, left, mid -1, n);
            } else {
                return searchRotatedArray(arr, mid+1, right, n);
            }
        } else if (arr[mid] < arr[right]){// if right half is sorted
            if (n > arr[mid] && n <= arr[right]){// its in the right side
               return searchRotatedArray(arr, mid+1, right, n);
            } else {
                return searchRotatedArray(arr, left, mid-1, n);
            }
        } else if( arr[mid] == arr[left]){
            if (arr[mid] != arr[right]){
                return searchRotatedArray(arr, mid+1, right, n);
            } else {
                int result = searchRotatedArray(arr, left, mid -1 , n);
                if (result == -1){
                    return searchRotatedArray(arr, mid+1, right, n);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {3,1,1};
        System.out.println( "The index is: " + searchRotatedArray(arr, 0, 2, 3));
    }
}


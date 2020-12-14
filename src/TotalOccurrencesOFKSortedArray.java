public class TotalOccurrencesOFKSortedArray {
    enum SearchType{
        First, Last
    }

    public static  int getOccurrencesOfK(int[] arr, int k){
        int firstOccurrence = binarySearch(arr, k, 0, arr.length-1, SearchType.First);
        if (firstOccurrence == -1){
            return 0;
        }
        int lastOccurrence = binarySearch(arr, k, 0, arr.length-1, SearchType.Last);
        return (lastOccurrence - firstOccurrence) + 1;
    }

    public static int binarySearch(int[] arr, int k, int left, int right, SearchType searchType){

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

    private static boolean isInBounds(int[] arr, int i) {
        return i < arr.length && i >= 0 ;
    }

    public static void main(String[]args){
        int [] arr = new int[]{1,1,1,2,3};
        int k = 1;
        System.out.println(getOccurrencesOfK(arr, k));
    }
}


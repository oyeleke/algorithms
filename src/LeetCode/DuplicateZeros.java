package LeetCode;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length - 1;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                int d = i+1;
                for(int j = n ; j >= d; j--){
                    arr[j] = arr[j-1];
                }
                arr[d] = 0;
                i++;
            }
        }
    }

    public void duplicateZeros2(int[] arr) {
        int []n = new int[arr.length];
        int j =0;
        for(int i = 0; j < arr.length; i++){
            if(arr[i] == 0){
                j++;
            } else {
                n[j] = arr[i];
            }
            j++;
        }

        for (int i = 0; i<arr.length; i++){
            arr[i] = n[i];
        }
    }
}

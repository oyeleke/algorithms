package LeetCode;

public class ValidMountainArray {
    public boolean validMountainArraySmallSize(int[] A) {

        if (A == null || A.length < 3) {
            return false;
        }

        int mvt = 0;

        for (int i = 1; i < A.length; i++) {

            System.out.println(mvt + " / " + i);

            if (mvt > 2) {
                return false;
            }

            if (A[i] == A[i - 1]) {
                return false;
            }

            if (mvt == 0 && A[i] < A[i - 1]) {
                return false;
            }

            if (mvt == 0 && A[i] > A[i - 1]) {
                mvt++;
                continue;
            }

            if (mvt == 1 && A[i] < A[i - 1]) {
                mvt++;
                continue;
            }

            if (mvt == 2 && A[i] > A[i - 1]) {
                return false;
            }

        }

        return mvt == 2;

    }

    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        if(arr[0] > arr[1]){
            return false;
        }

        int peak = -1;
        for(int i = 1; i< arr.length; i++){
            if(arr[i-1] == arr[i]){
                return false;
            }
            if(arr[i-1] > arr[i]){
                peak = i-1;
                break;
            }
        }

        if(peak == -1 || peak == arr.length){
            return false;
        }

        for(int j = peak+1; j < arr.length - 1 ; j++){
            if(arr[j] <= arr[j+1]){
                return false;
            }
        }
        return true;
    }
}

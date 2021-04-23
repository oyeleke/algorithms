package algoerxpertss;

public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        boolean result = true;
        //checking for increasing first
        for(int i = 1; i< array.length; i++){
            int j = i-1;
            if(array[j] > array[i] ){
                result = false;
                break;
            }
        }

        // check for decreasing
        if(!result){
            result = true;
            for(int i = 1; i< array.length; i++){
                int j = i-1;
                if(array[j] < array[i]){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isMonotonic2(int[] array){
        if (array.length <= 2) return true;
        int direction = array[1] - array[0];
        for (int i = 2; i< array.length; i++){
            if (direction == 0){
                direction = array[i] - array[i-1];
                continue;
            }

            if (breaksDifference(direction, array[i-1], array[i])){
                return false;
            }
        }
        return true;
    }

    private static boolean breaksDifference(int direction, int previous, int current){
        int difference = current - previous;
        if (direction > 0) return difference < 0;
        return difference > 0;
    }
}

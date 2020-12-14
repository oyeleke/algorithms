package LeetCode;

import java.util.HashMap;

public class CheckIfDoubleExists {

    public boolean checkIfExist(int[] arr) {

        HashMap<Integer, Integer>keeps = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            keeps.put(arr[i], (keeps.get(arr[i]) != null ? keeps.get(arr[i]) + 1 : 0));
        }

        for(int j = 0; j < arr.length; j++){
            if(keeps.get(arr[j] * 2) != null){
                if(arr[j] == 0){
                    if(keeps.get(0) >= 1){
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}

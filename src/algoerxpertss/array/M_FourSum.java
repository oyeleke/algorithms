package algoerxpertss.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M_FourSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        if(array.length < 4) return new ArrayList<Integer[]>();
        List<Integer[]> arrayList = new ArrayList<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i< array.length; i++){

            for(int k = i+1; k < array.length; k++){
                int twoDiff = targetSum - (array[k] + array[i]);
                if (map.containsKey(twoDiff)){
                    for (int[] twoSums :
                            map.get(twoDiff)) {
                        Integer [] resultToAdd = new Integer[]{array[k], array[i], twoSums[0], twoSums[1]};
                        arrayList.add(resultToAdd);
                    }
                }
            }

            for(int j = 0; j < i; j++){
                int currentSum = array[i] + array[j];
                if(map.containsKey(currentSum)){
                    map.get(currentSum).add(new int[]{array[i], array[j]});
                } else {
                    List<int[]> current = new ArrayList<>();
                    current.add(new int[]{array[i], array[j]});
                    map.put(currentSum, current);
                }
            }
        }

        return arrayList;
    }
}

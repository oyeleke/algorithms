package hackerrank.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, List<Integer>>map = new HashMap<>();
        List<List<Long>> arrs = new ArrayList<>();
        long totalNo = 0L;

        for (int i =0; i< arr.size(); i++){

            if (map.containsKey(arr.get(i))){
                List<Integer> temp = map.get(arr.get(i));
                temp.add(i);
                map.put(arr.get(i), temp);
            } else {
                List<Integer> newInt = new ArrayList<>();
                newInt.add(i);
                map.put(arr.get(i), newInt);
            }
        }

        for (int i = 0; i <= arr.size() - 2; i++){
            removeAllIndicies(map, i);
            HashMap<Long, List<Integer>>tempMap = map;
            while (true){
                long a = arr.get(i);
                long b = r * a;
                if (b == Integer.MAX_VALUE) break;
                if (tempMap.containsKey(b) && !tempMap.get(b).isEmpty()){
                    tempMap.get(b).remove(0);
                    long c = b * r;
                    if (c == Integer.MAX_VALUE) break;
                    if (tempMap.containsKey(c) && !tempMap.get(c).isEmpty()){
                        tempMap.get(c).remove(0);
                        totalNo++;
                    } else {
                        break;
                    }

                    } else {
                    break;
                }

            }
        }

        return totalNo;
    }

    public static  void removeAllIndicies(HashMap<Long, List<Integer>>map, int i){
        for (long d:
             map.keySet()) {
            List<Integer> temp = map.get(d);

            for(int j = 0; j < temp.size(); j++){
                if (temp.get(j) <= i){
                    temp.remove(j);
                    j--;
                }
            }
        }
    }

    public static <T> HashMap<Integer, List<T>> deepCopyWorkAround(HashMap<Integer, List<T>> original)
    {
        HashMap<Integer, List<T>> copy = new HashMap<>();
        for (Map.Entry<Integer, List<T>> entry : original.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }

    static long countTripletst(List<Long> arr, long r) {
        HashMap<Long, Long>counter = new HashMap<>();
        HashMap<Long, Long>possible = new HashMap<>();
        long totalNo = 0;

        for (int i = 0; i< arr.size(); i++){
            long a = arr.get(i);
            long k = a/r;

            if (counter.containsKey(k) && a%r == 0){
                totalNo += counter.get(k);
            }

            if (possible.containsKey(k) && a%r == 0){
                long c = possible.get(k);
                counter.put(a, counter.getOrDefault(a, 0L)+c);
            }

            possible.put(a, possible.getOrDefault(a, 0L)+1);

        }


        return totalNo;
    }
}

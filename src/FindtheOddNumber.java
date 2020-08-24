import java.util.*;

public class FindtheOddNumber {
    public int solution(int[] A) {
        // write your code in Java SE 8

        HashMap<Integer, Integer> numMap = new HashMap<>();
        Set<Integer> numSet = new HashSet<>();
        int oddNum = 0;

        for (Integer a:
             A) {
            if (numSet.add(a)) {
                numMap.put(a, 1);
            } else {
                numMap.put(a, numMap.get(a) + 1);
            }
        }


        for (int b: numMap.keySet()
             ) {
            if (numMap.get(b) % 2 != 0){
                oddNum = b;
                break;
            }
        }
        return oddNum;
    }
}

package codewars;

import java.util.HashMap;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here
        String sampleText = text.toLowerCase();
        int count = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < sampleText.length(); i++){
            char c = sampleText.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }

        for (Character c : countMap.keySet()){
            if (countMap.get(c) > 1) count++;
        }
        return count;
    }
}

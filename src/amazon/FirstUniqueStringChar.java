package amazon;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueStringChar {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        Map<Character, Integer> maps =  new HashMap<>();
        for (char c : s.toCharArray()){
            maps.put(c, maps.getOrDefault(c, 0)+1);
        }
        for (int i = 0; i < s.length(); i++){
            if (maps.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }
}

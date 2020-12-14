package LeetCode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Anagram {
    private int[] PRIMES = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,  71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> ans = new HashMap<>();
        List<List<String>> ret = new ArrayList();

        for (String s : strs) {
            long key = 1;

            for (int i = 0; i < s.length(); i++)
                key *= PRIMES[s.charAt(i) - 'a'];

            if (!ans.containsKey(key)) {
                List newList = new ArrayList();
                ans.put(key, newList);
                ret.add(newList);
            }
            ans.get(key).add(s);
        }
        return ret;
    }
}

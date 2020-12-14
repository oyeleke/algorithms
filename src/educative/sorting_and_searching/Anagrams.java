package educative.sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    public static String groupAnagrams(String arr[]) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            String word = arr[i];
            char[] wordAsChar = word.toCharArray();
            Arrays.sort(wordAsChar);
            String sortedString = new String(wordAsChar);

            if (hashMap.containsKey(sortedString)){
                hashMap.get(sortedString).add(word);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                hashMap.put(sortedString, newList);
            }
        }

        //write your code here
        StringBuilder anagrams = new StringBuilder();

        for (String value: hashMap.keySet()){
            List<String> newList = hashMap.get(value);
            if (newList.size() > 1){
                anagrams.append(newList);
            }
        }
        return anagrams.toString();
    }

    public static void main(String[] args) {
        String arr[] = {
                "cat",
                "dog",
                "tac",
                "god",
                "act",
                "tom marvolo riddle ",
                "abc",
                "def",
                "cab",
                "fed",
                "clint eastwood ",
                "i am lord voldemort",
                "elvis",
                "old west action",
                "lives"
        };
        System.out.println(groupAnagrams(arr));
    }
}

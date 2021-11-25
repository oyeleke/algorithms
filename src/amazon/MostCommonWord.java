package amazon;


import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String lowerCase = paragraph.toLowerCase();
        String[] array = lowerCase.split(" ");
        Map<String, Integer> maps = new HashMap<>();
        //clean array
        for (int i = 0; i < array.length; i++) {
            array[i] = returnCleanString(array[i]);
        }

        for (String c : array) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }

        for (String d : banned) {
            maps.put(d, -1);
        }
        String ans = "";
        int smallest = Integer.MIN_VALUE;
        for (String c : maps.keySet()) {
            if (smallest < maps.get(c)) {
                ans = c;
                smallest = maps.get(c);
            }
        }
        return ans;
    }


    public String returnCleanString(String string) {
        HashMap<Character, Integer> hashMap = new HashMap() {
            {
                put('!', 1);
                put('?', 1);
                put('\'', 0);
                put(',', 0);
                put(';', 0);
                put('.', 0);
            }
        };

        char[] charArray = string.toCharArray();
        int last = charArray.length - 1;
        if (hashMap.containsKey(charArray[0])) {
            charArray[0] = ' ';
        }

        if (hashMap.containsKey(charArray[last])) {
            charArray[last] = ' ';
        }
        return new String(charArray).trim();
    }

    public String mostCommonWord2(String paragraph, String[] banned) {

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        String ans = "";
        int maxCount = 0;
        Map<String, Integer> wordCount = new HashMap();
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();

        for (int p = 0; p < chars.length; ++p) {
            char currChar = chars[p];

            // 1). consume the characters in a word
            if (Character.isLetter(currChar)) {
                wordBuffer.append(Character.toLowerCase(currChar));
                if (p != chars.length - 1)
                    // skip the rest of the processing
                    continue;
            }

            // 2). at the end of one word or at the end of paragraph
            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                // identify the maximum count while updating the wordCount table.
                if (!bannedWords.contains(word)) {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }
                }
                // reset the buffer for the next word
                wordBuffer = new StringBuilder();
            }
        }
        return ans;
    }

    public String mostCommonWord3(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();

        for (String s : banned){
            bannedWords.add(s);
        }

        String ans = "";
        int maxCount = 0;
        char [] chars = paragraph.toCharArray();
        Map<String, Integer>maps = new HashMap<>();
        StringBuilder bufferedwords = new StringBuilder();

        for(int i = 0; i < chars.length; ++i){
            char currChar = chars[i];

            if (Character.isLetter(currChar)){
                bufferedwords.append(Character.toLowerCase(currChar));
                if (i != chars.length - 1){
                    continue;
                }
            }

            if (bufferedwords.length() > 0){
                String word = bufferedwords.toString();
                if (!bannedWords.contains(word)){
                    int nextScore = maps.getOrDefault(word, 0) + 1;
                    if (nextScore > maxCount){
                        maxCount = nextScore;
                        ans = word;
                    }
                }
            }
            bufferedwords = new StringBuilder();
        }
        return ans;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i<n; i++){
            int count = map.getOrDefault(ar.get(i), 0)+1;
            map.put(ar.get(i), count);
        }

        for(int key : map.keySet()){
            ans = ans + (map.get(key)/2);
        }
        return ans;
    }
}

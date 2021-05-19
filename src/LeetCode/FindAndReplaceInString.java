package LeetCode;

import java.util.HashMap;

public class FindAndReplaceInString {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, String>indexTarget = new HashMap<>();
        HashMap<Integer, String>indexSource = new HashMap<>();

        for (int i = 0; i< indexes.length; i++){
          if (indexes[i] < s.length()){
              if (s.startsWith(sources[i], indexes[i])){
                  indexTarget.put(indexes[i], targets[i]);
                  indexSource.put(indexes[i], sources[i]);
              }
          }
        }

        StringBuilder result = new StringBuilder();

        for (int j = 0; j < s.length(); j++){
            if (indexTarget.containsKey(j)){
                result.append(indexTarget.get(j));
                j = j+indexSource.get(j).length()-1;
            } else {
                result.append(s.charAt(j));
            }
        }


        return result.toString();
    }
}

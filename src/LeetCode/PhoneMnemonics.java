package LeetCode;

import java.util.*;

public class PhoneMnemonics {


    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> mapDigitToSting = new HashMap<>();
        mapDigitToSting.put('2', "abc");
        mapDigitToSting.put('3', "def");
        mapDigitToSting.put('4', "ghi");
        mapDigitToSting.put('5', "jkl");
        mapDigitToSting.put('6', "mno");
        mapDigitToSting.put('7', "pqrs");
        mapDigitToSting.put('8', "tuv");
        mapDigitToSting.put('9', "wxyz");
        StringBuilder parser = new StringBuilder();
        combineStringPosibilities(0, parser, result, digits, mapDigitToSting);
        return result;
    }

    public static void combineStringPosibilities(int digitCount, StringBuilder parser, List<String> result, String digitString, HashMap<Character, String> map){
        if (digitCount == digitString.length()){
            result.add(parser.toString());
            return;
        }
        Character currentDigit = digitString.charAt(digitCount);
        String letters = map.get(currentDigit);

        for (char c : letters.toCharArray()){
            parser.append(c);
            combineStringPosibilities(digitCount + 1, parser, result, digitString, map);
            parser.deleteCharAt(parser.length() - 1);
        }
    }

    public static void main(String [] args){
        System.out.println(letterCombinations("23"));
    }
}

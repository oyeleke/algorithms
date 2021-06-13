package elements_of_programming_interviews;

import java.util.HashMap;

public class RomanToDecimal {

    public static int romanToInteger(String s){

        if (s == null || s.length() <= 0) return 0;

        HashMap<Character, Integer>hashMap = new HashMap(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int sum = hashMap.get(s.charAt(s.length()-1));

        for(int i = s.length()-2; i >=0; i--){

            if (hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i+1))){
                sum -= hashMap.get(s.charAt(i));
            } else {
                sum += hashMap.get(s.charAt(i));
            }
        }


        return sum;
    }
}

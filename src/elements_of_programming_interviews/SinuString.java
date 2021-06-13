package elements_of_programming_interviews;

public class SinuString {

    public static String snakeString (String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < s.length(); i+=4){
            result.append(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i+=2){
            result.append(s.charAt(i));
        }

        for (int i = 3; i < s.length(); i+=4){
            result.append(s.charAt(i));
        }

        return result.toString();
    }

}

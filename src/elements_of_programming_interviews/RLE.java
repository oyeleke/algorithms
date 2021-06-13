package elements_of_programming_interviews;

public class RLE {
    public static String decoding(String s){
        int count = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                count = count * 10 + c - '0';
            } else {
                while (count > 0){
                    result.append(c);
                    count--;
                }
            }
        }

       return result.toString();
    }

    public static String encoding(String s){
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= s.length(); ++i){

            if (i == s.length() || s.charAt(i) != s.charAt(i-1)){
                result.append(count);
                result.append(s.charAt(i-1));
                count = 1;
            }else {
                count++;
            }
        }
        return result.toString();
    }

    public static void main(String [] args){
        String result = decoding("3e4f2e");
        System.out.println(result);
        String result2 = encoding("eeeffffee");
        System.out.println(result2);
    }
}

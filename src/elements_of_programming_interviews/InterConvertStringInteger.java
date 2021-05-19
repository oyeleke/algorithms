package elements_of_programming_interviews;

public class InterConvertStringInteger {

    public static String intToString(int x){
        boolean isNegative = false;

        if(x < 0){
            isNegative = true;
        }
        StringBuilder s = new StringBuilder();
        do {
            s.append( (char) (Math.abs(x%10) + '0'));
            x = x/10;
        }while (x != 0);

        if (isNegative){
            s.append('-');
        }

        return s.reverse().toString();
    }

    public static int stringToInt(String x){
        int result = 0;
        for (int i = x.charAt(0) != '-' ? 0 : 1; i < x.length(); i++){
            final int digit = x.charAt(i) - '0';
            result = 10 * result + digit;
        }

        return x.charAt(0) == '-' ? -result : result;
    }


    public static void main(String [] args){

        int result = stringToInt("-123");
        if (result == -123) {
            System.out.print(result);
        }
    }
}

package codewars;

public class SumOfDigits {

    public static int digital_root(int n) {
        while(String.valueOf(n).length() > 1){
            int s  = n;
            int addition = 0;
            while(s > 0){
                addition += s % 10;
                s /= 10;
            }
            n = addition;
        }


        return n;
    }

        public static int digital_rootf(int n) {
            while(n > 9){
                n = n/10 + n % 10;
            }
            return(n);
        }


    public static int getNumberOfDigits(int n){
        return String.valueOf(n).length();
    }

    public static void main(String[] args) {
        System.out.println(digital_root(132189));
    }
}

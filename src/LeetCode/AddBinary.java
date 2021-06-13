package LeetCode;

public class AddBinary {

    public  static String addBinary(String a, String b) {
        int d = a.length(), e = b.length();

        if (d < e) return addBinary(b, a);
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0, j = e-1;
        for (int i = d-1; i > -1; i--){

            if (a.charAt(i) == '1') carry++;
            if (j > -1 && b.charAt(j--) == '1') carry++;

            if (carry % 2 == 1){
                stringBuilder.append('1');
            } else if (carry % 2 == 0){
                stringBuilder.append('0');
            }

            carry /= 2;
        }

        if (carry == 1) stringBuilder.append('1');
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}

package elements_of_programming_interviews;

class AddBinary {
    public  String addBinary(String a, String b) {
        char [] aa = a.toCharArray();
        char [] bb = b.toCharArray();
        int maxlen = Math.max(aa.length, bb.length);
        String result = "";
        int remainder = 0;
        for (int i =0; i< maxlen; i++){

            int aVal = (i < aa.length) ? aa[aa.length - i -1]- '0' : 0;
            int bVal = (i < bb.length) ? bb[bb.length - i -1] -'0' : 0;

            String r = add(aVal, bVal, remainder);

            switch (r){
                case "00":
                    result += "0";
                    remainder = 0;
                    break;

                case "01":
                     result += "1";
                     remainder = 0;
                     break;

                case "10":
                    result += "0";
                    remainder = 1;
                    break;

                case "11":
                    result += "1";
                    remainder = 1;
                    break;
            }
        }

        if (remainder == 1) result += "1";

        return new StringBuilder(result).reverse().toString();
    }

    public static String addBinary2(String a, String b){
        int d = a.length(), e = b.length();
        if (d < e) return addBinary2(b, a);
        int carry = 0, j = e - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = d -1  ; i > -1; --i){
            if (a.charAt(i) == '1') carry++;
            if (j > -1 && b.charAt(j--) == '1') carry++;

            if (carry % 2 == 1) sb.append("1");
            else sb.append("0");

            carry /= 2;
        }
        if (carry == 1) sb.append("1");
        return sb.reverse().toString();
    }

    public  String add(int a, int b, int rem){
        int count = 0;
        if(a == 1) count++;
        if(b == 1) count++;
        if (rem == 1) count++;

        if (count == 0) return "00";
        else if (count == 1) return "01";
        else if (count == 2) return "10";
        else {
            return "11";
        }
    }

    public static void main(String [] args){
        String a = "110";
        String b = "111";

        System.out.println(String.valueOf(34).equals("34"));
    }
}

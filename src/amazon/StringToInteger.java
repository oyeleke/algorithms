package amazon;

public class StringToInteger {

    public static int myAtoi(String s) {
        int ans = 0;
        if (s == null || s.isEmpty()) {
            return ans;
        }
        int min = -2147483648;
        int max = 2147483647;
        Boolean ispositive = null;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                break;
            }

            if (s.charAt(i) == '-') {
                if (builder.length() == 0 && ispositive == null) {
                    ispositive = false;
                    continue;
                } else {
                    break;
                }
            }

            if (s.charAt(i) == '+') {
                if (builder.length() == 0 && ispositive == null) {
                    ispositive = true;
                    continue;
                } else {
                    break;
                }
            }


            if (s.charAt(i) == ' ') {
                if (builder.length() == 0 && ispositive == null) {
                    continue;
                } else {
                    break;
                }
            }
            if (Character.isDigit(s.charAt(i))) {
                builder.append(s.charAt(i));
            }

            if (Character.isLetter(s.charAt(i)) && s.charAt(i) != '-' && s.charAt(i) != '+') {
                if (builder.length() == 0) {
                    return ans;
                } else {
                    break;
                }
            }
        }
        if (builder.length() == 0) {
            return ans;
        }

        try {
            ans = Integer.parseInt(builder.toString());
        } catch (NumberFormatException exception) {
            if (ispositive) {
                return max;
            } else {
                return min;
            }
        }

        if (ispositive == null) {
            ispositive = true;
        }

        return ispositive ? ans : -ans;
    }

    public static void main(String[] args) {
        System.out.print(myAtoi("+-12"));
    }

    public int myAtoi2(String s) {
        long res = 0;
        int isNeg = 1;
        boolean start = false;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (start) {
                    break;
                }
                continue;
            }

            if (!((c >= '0' && c <= '9') || (c == '-' && !start) || (c == '+' && !start))) {
                break;
            }

            if (c == '-') {
                isNeg = -1;
                start = true;
                continue;
            } else if (c == '+') {
                start = true;
                continue;
            }

            start = true;
            res = res * 10 + (c - '0');
            if (isNeg * res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (isNeg * res <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return isNeg * (int) res;
    }

    public int myAtoi3(String s){
        long res = 0;
        int neg = 1;
        boolean start = false;

        for (char c : s.toCharArray()){

            if (c == ' '){
                if (start){
                    break;
                }
                continue;
            }

            if (!((c >= '0' || c <= '9') || (c == '-' && start) || (c == '+' && start))){
                break;
            }

            if (c == '-'){
                neg = -1;
                start = true;
                continue;
            } else if(c == '+'){
                neg = 1;
                start = true;
            }

            start = true;

            res = res * 10 + (c - '0');
            if (res * neg > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            } else if(res * neg < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }

        return (int) ( neg*res);
    }

}

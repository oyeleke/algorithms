package LeetCode;

public class ConvertToBaseMinus2 {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        String base2String = buildBase2FromInteger(N);
        if (base2String.length() % 2 == 0) {
            return "1" + base2String;
        } else {
            return base2String;
        }
    }

    public String buildBase2FromInteger(int x) {
        return (x == 0) ? " " :
                buildBase2FromInteger(x / 2) + (char) '0' + x % 2;
    }

    public String baseNeg22(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        while(N != 0){
            int rem = N%(-2);
            N /= (-2);
            if (rem < 0){
                N++;
                rem += 2;
            }
            builder.append(rem);
        }
        return builder.reverse().toString();
    }
    // a = (-r)c+d = (-r)c+d-r+r = (-r)(1+c) + (r+d)
}

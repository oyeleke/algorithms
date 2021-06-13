package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.List;

public class AllValidIPAddress {

    public static List<String> getValidIpAddress(String s) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i < 4 && i < s.length(); i++) {
            final String first = s.substring(0, i);
            if (isValid(first)) {
                for (int j = 1; j < 4 && j + i < s.length(); i++) {
                    final String second = s.substring(i, i + j);

                    if (isValid(second)) {
                        for (int k = 1; k + j + i < s.length() && k < 4; i++) {
                            final String third = s.substring(i+j, i + j + k);
                            final String fourth = s.substring(i + j + k);

                            if (isValid(third) && isValid(fourth)){
                                result.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    static boolean isValid(String s) {
        if (s.length() > 3) {
            return false;
        }

        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }

        int num = Integer.parseInt(s);
        return num <= 255 && num >= 0;
    }
}

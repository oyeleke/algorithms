package LeetCode;

import java.util.*;

class MultiplyString {
    public String multiply(String num1, String num2) {

        char[] num11 = num1.toCharArray();
        char[] num22 = num2.toCharArray();
        List<Integer> list1 = convertCharArrayToListOfInteger(num11);
        List<Integer> list2 = convertCharArrayToListOfInteger(num22);
        List<Integer> result = multiply(list1, list2);
        return convertIntListToString(result);
    }

    public List<Integer> convertCharArrayToListOfInteger(char[] A) {
        List<Integer> list = new ArrayList(Collections.nCopies(A.length, 0));

        for (int i = 0; i < A.length; i++) {
            list.set(i, Character.getNumericValue(A[i]));
        }
        return list;
    }

    public List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(j + i + 1, result.get(j + i + 1) + (num1.get(i) * num2.get(j)));
                result.set(j + i, result.get(i + j + 1) / 10 + result.get(j + i));
                result.set(j + i + 1, result.get(j + i + 1) % 10);
            }
        }

        int leading0 = 0;
        while (leading0 < result.size() && result.get(leading0) == 0) {
            ++leading0;
        }
        result = result.subList(leading0, result.size());

        if (result.isEmpty()) {
            return Collections.singletonList(0);
        }
        result.set(0, result.get(0) * sign);
        return result;
    }

    public String convertIntListToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.valueOf(list.get(i)));
        }
        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        char[] a1 = num1.toCharArray();
        char[] a2 = num2.toCharArray();

        int[] sum = new int[a1.length + a2.length];
        for (int i =0; i < a1.length; i++) {
            for(int j = 0; j < a2.length; j++) {
                sum[i+j+1] += ((a1[i]-'0')*(a2[j]-'0'));
            }
        }
        int carry = 0;
        for (int i = sum.length-1; i >= 0; i--) {
            carry += sum[i];
            sum[i] = carry % 10;
            carry /= 10;
        }

        int i = 0;
        while (i < sum.length-1 && sum[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i < sum.length) {
            sb.append(sum[i++]);
        }

        return sb.toString();
    }
}

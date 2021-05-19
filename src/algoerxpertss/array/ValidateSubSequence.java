package algoerxpertss.array;

import java.util.*;

class ValidateSubSequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int i = 0;
        for (int k : array) {
            System.out.println(i);

            if (k == sequence.get(i)) {
                i++;
            }
            if (i > sequence.size()-1 ) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(
                Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        List<Integer> sequence = new ArrayList<>(
                Arrays.asList(1, 6, -1, 10)
        );
        boolean result = isValidSubsequence(array, sequence);
        System.out.println(result);
    }
}

package backtobackswe.searching;

import java.util.List;

public class FirstOccurrenceOfK {

    public static int searchFirstOfK(List<Integer> A, int k) {
        int result =0, left = 0, right = A.size() - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(A.get(mid) > k){
                right = mid - 1;
            } else if(A.get(mid) == k){
                result = mid;
                right = mid - 1;
            } else {
                left = mid +1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(searchFirstOfK(List.of(-14,-10, 2, 108, 108, 243,285,285, 285, 401), 285));
    }
}

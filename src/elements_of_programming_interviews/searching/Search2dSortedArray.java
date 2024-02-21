package elements_of_programming_interviews.searching;

import java.util.List;

public class Search2dSortedArray {

    public static boolean matrixSearch(List<List<Integer>> A, int x) {
        int row =0; int col = A.get(0).size() - 1;

        while (row < A.size() && col >= 0){
            if (A.get(row).get(col) == x){
                return true;
            } else if (x > A.get(row).get(col)){
                row++;
            } else if (x < A.get(row).get(col)){
                col--;
            }
        }

        return false;
    }
}

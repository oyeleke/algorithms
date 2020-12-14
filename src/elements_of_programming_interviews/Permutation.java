package elements_of_programming_interviews;

import java.util.Collections;
import java.util.List;

public class Permutation {

    public static void applyPermutation(List<Integer> perm, List<Integer> A){
        for (int i = 0; i< A.size(); i++){

            int next = i;

            while (perm.get(next) >= 0){
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }

        for (int i = 0; i< perm.size(); i++){
            perm.set(i, perm.get(i) + perm.size());
        }
    }
}

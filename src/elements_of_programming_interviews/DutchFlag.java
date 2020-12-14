package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchFlag {
    public static void dutchFlagPartition(int pivotIndex, List<Integer> A){
       int pivot = A.get(pivotIndex);

       int smaller = 0, equal = 0, larger = A.size();

       while (equal < larger){
           if (A.get(equal) < pivot){
               Collections.swap(A, smaller++, equal++);
           }
           else if (A.get(equal) == pivot){
               equal++;
           } else {
               Collections.swap(A, equal, --larger);
           }

       }
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>(
                Arrays.asList(0,1,3,2,3,0,2,1,1,3)
        );

        dutchFlagPartition(0,list);

        System.out.println("ArrayList : " + list);
    }

}

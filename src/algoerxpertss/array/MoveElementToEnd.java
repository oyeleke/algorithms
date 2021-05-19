package algoerxpertss.array;

import java.util.Collections;
import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int j = 0, i = 0;
        int n = array.size();
        while(i < n){
            if(array.get(i) == toMove && array.get(j) != toMove){
                j = i;
            }
            else if(array.get(i) != toMove && array.get(j) == toMove){
                Collections.swap(array, i, j);
                j++;
            }
            i++;
        }
        return array;
    }
}

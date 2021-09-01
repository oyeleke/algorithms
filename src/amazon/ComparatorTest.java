package amazon;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

    public static Integer [] testing(Integer [] a){
        //sort in decending order
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return -1;
                } else if(o1 < o2){
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(a, comp);
        return a;
    }

    public static void main(String[] args) {
        Integer [] a = new Integer[]{5,7,4,2,8,9,0};
        Integer [] b = testing(a);

        for (Integer c : b){
            System.out.print(c+ " ");
        }
    }
}

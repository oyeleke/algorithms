package hackerrank.sorting;

import java.util.Comparator;
import java.util.List;

public class MarkAndToys {

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        if (k == 0 || prices.isEmpty()){
            return 0;
        }
        Comparator<Integer> comparator = Integer::compare;
        prices.sort(comparator);
        int amount = 0;
        int count = 0;
        for (int i = 0; i < prices.size(); i++){
            int check = amount + prices.get(i);
            if (check >= k){
                break;
            } else {
                amount += prices.get(i);
                count++;
            }
        }

        return count;
    }
}

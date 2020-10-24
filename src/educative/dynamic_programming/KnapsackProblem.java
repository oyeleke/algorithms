package educative.dynamic_programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class KnapsackProblem
{
    static int Knapsack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity)
    {
        HashMap<Integer, Integer>indexToProfit = new HashMap<>();
        int currentWeight = 0;

        for (int i= 0; i< profitsLength; i++){
            indexToProfit.put(i, profits[i]);
        }

        Arrays.sort(profits);

        for (int i = profitsLength-1; i >= 0;  i--){
            
        }

        return -1;
    }
};

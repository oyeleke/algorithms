package hackerrank.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        int qs = queries.size();
        HashMap<Integer, Integer> querySafe = new HashMap<>(qs);
        HashMap<Integer, Integer> freqOccurrence = new HashMap<>(qs);

        for (List<Integer> query : queries) {
            Integer value = query.get(1);
            int oldCount = querySafe.getOrDefault(value, 0);
            int newCount;
            switch (query.get(0)) {
                case 1: {
                    newCount = oldCount + 1;
                    querySafe.put(value, newCount);

                    if (freqOccurrence.containsKey(oldCount) && freqOccurrence.get(oldCount) > 0) {
                        freqOccurrence.put(oldCount, freqOccurrence.get(oldCount) - 1);
                    }
                    freqOccurrence.put(newCount, freqOccurrence.getOrDefault(newCount, 0) + 1);
                    break;
                }

                case 2: {
                    newCount = (oldCount > 1) ? oldCount - 1 : 0;
                    querySafe.put(value, newCount);
                    if (freqOccurrence.containsKey(oldCount) && freqOccurrence.get(oldCount) > 0) {
                        freqOccurrence.put(oldCount, freqOccurrence.get(oldCount) - 1);
                    }
                    freqOccurrence.put(newCount, freqOccurrence.getOrDefault(newCount, 0) + 1);

                    break;
                }
                case 3: {
                    if (freqOccurrence.containsKey(value) && freqOccurrence.get(value) > 0) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;
                }
            }
        }

        return result;

    }
}

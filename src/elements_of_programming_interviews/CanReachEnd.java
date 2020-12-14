package elements_of_programming_interviews;

import java.util.List;

public class CanReachEnd {

    public static boolean canReachEnd(List<Integer> maxAdvanceSteps){
        int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.size() -1;

        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i){
            furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
        }

        return furthestReachSoFar >= lastIndex;
    }

    public static int minimumNoOfSteps(List<Integer> maxAdvanceSteps){
        int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.size() -1;
        int minSteps = 0;
        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i){
            if (furthestReachSoFar < (i + maxAdvanceSteps.get(i)) ){
                furthestReachSoFar = i + maxAdvanceSteps.get(i);
                minSteps++;
            }
        }

        return minSteps;
    }

}

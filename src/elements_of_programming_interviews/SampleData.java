package elements_of_programming_interviews;

import java.util.*;

public class SampleData {
    //sample offline data
    public static void randomsampling(int k, List<Integer> A) {
        Random gen = new Random();
        for (int i = 0; i <= k; i++){
            Collections.swap(A, i, gen.nextInt(A.size() - i));
        }
    }

    // sample online Data
    // assumption that sequence has more than k
    public static List<Integer> onlineRandomSample(Iterator<Integer> sequence, int k){
        List<Integer> uniformDist = new ArrayList<>(k);

        for(int i = 0; sequence.hasNext() && i<k; i++){
            uniformDist.add(sequence.next());
        }
        int numberSeenSoFar = k;
        Random random = new Random();
        while (sequence.hasNext()){
            Integer x = sequence.next();
            numberSeenSoFar++;

            int idxtoreplace = random.nextInt(numberSeenSoFar);

            if (idxtoreplace < k){
                uniformDist.set(idxtoreplace, x);
            }
        }
        return uniformDist;
    }
}

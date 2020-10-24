package codility;

public class CountFactors {
    public int solution(int N) {
       int result =  0;
       int i = 1;
       while (i*i < N){
           if (N % i == 0){
               result += 2;
           }
           i++;
       }

       if (i * i == N){
           result += 1;
       }

       return result;
    }

    public int solution2(int N) {
        int result = 0;
        int squaraRootN = (int)Math.sqrt(N);
        if (Math.pow(squaraRootN, 2) != N){
            squaraRootN++;
        } else {
            result++;
        }
        for ( int i = 1; i<squaraRootN; i++){
            if (N % i == 0){
                result +=2;
            }
        }
        return result;
    }
}

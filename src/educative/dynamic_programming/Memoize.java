package educative.dynamic_programming;

public class Memoize {

    public static int fib(int n, int[] lookUptable){

        if (lookUptable[n] == -1){
            if (n<= 1)
                lookUptable[n] = n;
            else
                lookUptable[n] = fib(n-1, lookUptable) + fib(n-2, lookUptable);
        }
        return lookUptable[n];
    }

    public static void main(String[] args){
        int n =6;
        int[] lookUpTable = new int[n+1];

        for (int i = 0; i < n+1; i++){
            lookUpTable[i] = -1;
        }

        System.out.println(fib(n, lookUpTable));
    }
}

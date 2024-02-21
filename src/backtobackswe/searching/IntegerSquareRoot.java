package backtobackswe.searching;

public class IntegerSquareRoot {
    public int squareRoot(int n) {
        long l = 0, r = n;
        while(l <= r){
            long mid = l + ((r - l)/2);
            System.out.println(mid);
            long mid2 = mid*mid;
            System.out.println("[ " + mid2 + " , " + n + " ]");
            if(mid2 <= n){
                l = mid+1;
            } else {
                r = mid - 1;
            }
            System.out.println("[ " + l + " , " + r + " ]");
        }
        return (int) (l-1);
    }

    public static void main(String[] args) {
        IntegerSquareRoot squareRoot = new IntegerSquareRoot();
        System.out.println(squareRoot.squareRoot(1000000));
    }
}

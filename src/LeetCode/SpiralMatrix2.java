package LeetCode;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int [][] array2d = new int[n][n];
        int dir = 0, x = 0, y = 0;
        int[][] Shift = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 1;

        for (int i = 0; i < n*n; i++){
            array2d[x][y] = count;
            count++;
            int xNext = x + Shift[dir][0];
            int yNext = y + Shift[dir][1];
            if (xNext < 0 || xNext >= n || yNext < 0 || yNext >= n || array2d[xNext][yNext] != 0){
                dir = (1 + dir) % 4;
                xNext = x + Shift[dir][0];
                yNext = y + Shift[dir][1];
            }
            x = xNext;
            y = yNext;
        }

        return array2d;
    }


    // less memory using pointers

    public int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];
        if (n == 1) {
            res[0] = new int[]{1};
            return res;
        }

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int k = 1;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) res[top][i] = k++;
            for (int i = top; i < bottom; i++) res[i][right] = k++;
            for (int i = right; i > left; i--) res[bottom][i] = k++;
            for (int i = bottom; i > top; i--) res[i][left] = k++;

            top++;
            bottom--;
            left++;
            right--;
        }

        if (left == right) {
            for (int i = top; i <= bottom; i++) res[i][right] = k++;
        } else if (top == bottom) {
            for (int i = left; i <= right; i++) res[top][i] = k++;
        }

        return res;
    }
}

package algoerxpertss.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverese {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        int x = 0;
        int y = 0;
        int m = array.length;
        int n = array[0].length;
        int s = Integer.MIN_VALUE;
        int direction = 0;
        int[][] SHIFT = {{0,1},{1,0}, {0,-1},{-1,0}};

        for(int i = 0; i < n*m; i++){
            result.add(array[x][y]);
            array[x][y] = s;
            int nextX = x+SHIFT[direction][0], nextY = y+SHIFT[direction][1];

            if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || array[nextX][nextY] == s){
                direction = (1+direction)%4;
                nextX = x+SHIFT[direction][0];
                nextY = y+SHIFT[direction][1];
            }
            x = nextX;
            y = nextY;
        }
        return result;
    }
}

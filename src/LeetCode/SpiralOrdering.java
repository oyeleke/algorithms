package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrdering {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList();
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int dir = 0, x = 0, y = 0;
        int[][] Shift = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < maxRow * maxCol; i++) {
            spiralList.add(matrix[x][y]);
            matrix[x][y] = 200;
            int xNext = x + Shift[dir][0];
            int yNext = y + Shift[dir][1];
            if (xNext < 0 || xNext >= maxRow || yNext < 0 || yNext >= maxCol ||
                    matrix[xNext][yNext] == 200) {
                dir = (1 + dir) % 4;
                xNext = x + Shift[dir][0];
                yNext = y + Shift[dir][1];
            }
            x = xNext;
            y = yNext;
        }
        return spiralList;
    }
}

package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.List;

public class Array2DSpiral {

    private static void matrixLayerlnClockwise(List<List<Integer>> squareMatrix, int offset,
                                               List<Integer> spiralOrdering) {
        if (offset == squareMatrix.size() - offset - 1) {
            //matrix is odd and we re at it its center
            spiralOrdering.add(squareMatrix.get(offset).get(offset));
        }

        //choose first row  first n-1 elements
        for (int j = 0; j < squareMatrix.size() - offset - 1; j++) {
            spiralOrdering.add(squareMatrix.get(offset).get(j));
        }

        //choose last col first n-1 elements

        for (int i = 0; i < squareMatrix.size() - offset - 1; i++) {
            spiralOrdering.add(squareMatrix.get(i).get(squareMatrix.size() - offset - 1));
        }

        // choose last row last n-1 elements in reverse order

        for (int j = squareMatrix.size() - offset - 1; j > offset; j--) {
            spiralOrdering.add(squareMatrix.get(squareMatrix.size() - offset - 1).get(j));
        }
        // chose las
        for (int i = squareMatrix.size() - offset - 1; i > offset; i--) {
            spiralOrdering.add(squareMatrix.get(i).get(offset));
        }

    }

    public static List<Integer> matrixInSpiralOrder( List<List<Integer>> squareMatrix){
        List<Integer> spiralOrdering = new ArrayList<>();

        for (int offset = 0; offset < Math.ceil(squareMatrix.size() * 0.5); offset++){
            matrixLayerlnClockwise(squareMatrix, offset, spiralOrdering);
        }

            return spiralOrdering;
    }

    public static List<Integer> matrixInSpiralOrder2( List<List<Integer>> squareMatrix) {
        List<Integer> spiralOrdering = new ArrayList<>();
        final int[] [] Shift = {{0,1}, {1,0}, {0, -1}, {-1, 0} };
        int dir = 0, y = 0, x =0;
        for (int i = 0; i < squareMatrix.size()* squareMatrix.size(); i++){
            spiralOrdering.add(squareMatrix.get(x).get(y));
            squareMatrix.get(x).set(y, 0);
            int xNext = x + Shift[dir][0];
            int yNext = y+ Shift[dir][1];
            if (xNext < 0 || xNext >= squareMatrix.size() || yNext < 0 || yNext >= squareMatrix.size() || squareMatrix.get(xNext).get(yNext) == 0){
                dir = (1 + dir) % 4;
                 xNext = x + Shift[dir][0];
                 yNext = y+ Shift[dir][1];
            }
            x = xNext;
            y = yNext;
        }

        return spiralOrdering;
    }

    }

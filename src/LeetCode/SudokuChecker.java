package LeetCode;

public class SudokuChecker {

    public boolean isValidSudoku(char[][] board) {

        // check row
        for (int i = 0; i < board.length; i++) {
            if (hasDuplicate(board, 0, board.length, i, i + 1)) {
                return false;
            }
        }

        // check column
        for (int j = 0; j < board.length; j++) {
            if (hasDuplicate(board, j, j + 1, 0, board.length)) {
                return false;
            }
        }

        // check region
        int rS = 3;
        for (int d = 0; d < rS; d++) {
            for (int e = 0; e < rS; e++) {
                if (hasDuplicate(board, rS * d, rS * (d + 1), rS * e, rS * (e + 1))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasDuplicate(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        boolean[] isPresent = new boolean[board.length];

        for (int i = startRow; i < endRow; ++i) {
            for (int j = startCol; j < endCol; ++j) {
                if (board[i][j] != '.' && isPresent[Character.getNumericValue(board[i][j])]) {
                    return true;
                }
                if (board[i][j] != '.'){
                    isPresent[Character.getNumericValue(board[i][j])] = true;
                }

            }
        }
        return false;
    }

}

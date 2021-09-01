package LeetCode;

import java.util.Collections;
import java.util.List;

public class SudokuValidatorRe {
    public boolean isValidSudoku(char[][] board) {
        // validate rows
        for (int i = 0; i < board.length; i++) {
            if (hasDuplicate(board, i, i + 1, 0, board.length)) {
                return false;
            }
        }

        //validate columns
        for (int j = 0; j < board.length; j++) {
            if (hasDuplicate(board, 0, board.length, j, j + 1)) {
                return false;
            }
        }

        //validate sections

        int section = (int) Math.sqrt(board.length);

        for (int i = 0; i < section; i++) {
            for (int j = 0; j < section; j++) {
                if (hasDuplicate(board, section * i, section * (i+1), section*j, section*(j+1))){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean hasDuplicate(char[][] board, int startRow, int endRow, int startCol, int endCol) {

        List<Boolean> isPresent = Collections.nCopies(board.length + 1, false);
        for (int i = startCol; i < endCol; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] != '.' && isPresent.get((Character.getNumericValue(board[i][j])))) {
                    return true;
                }
            }
        }
        return false;
    }
}

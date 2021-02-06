package LeetCode;

public class Rotate2dArray {
    public void rotate(int[][] matrix) {
        int matrixSize = matrix.length - 1;
        if (matrixSize != 0) {
            for (int i = 0; i < (matrix.length / 2); ++i) {
                for (int j = i; j < matrixSize - i; ++j) {

                    int temp1 = matrix[matrixSize - j][i]; //2 0
                    int temp2 = matrix[matrixSize - i][matrixSize - j]; //22
                    int temp3 = matrix[j][matrixSize - i];//0 2
                    int temp4 = matrix[i][j]; // 00

                    matrix[j][matrixSize - i] = temp4;
                    matrix[matrixSize - i][matrixSize - j] = temp3;
                    matrix[matrixSize - j][i] = temp2;
                    matrix[i][j] = temp1;
                }
            }
        }
    }
}

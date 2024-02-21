package backtobackswe.searching;


public class Search2DSortedMatrix {

    public boolean search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0){

            if (matrix[row][col] == target){
                return true;
            } else if (target > matrix[row][col]){
                row++;
            } else if (target < matrix[row][col]){
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DSortedMatrix search2DSortedMatrix =  new Search2DSortedMatrix();
        int [][] A = new int[][] {{0,1,2,3},{4,5,6,7},{8,9,10,11}};
        System.out.println(search2DSortedMatrix.search(A, 12));
    }
}

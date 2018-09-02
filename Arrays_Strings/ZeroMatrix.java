/*
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
*/
import java.util.HashSet;
public class ZeroMatrix {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        for (Integer row: rowSet) {
            setZero(matrix, row, true);
        }
        for (Integer col: colSet) {
            setZero(matrix, col, false);
        }
    }

    private void setZero(int[][] matrix, int index, boolean isRow) {
        if (isRow) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[index][col] = 0;
            }
        } else {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][index] = 0;
            }
        }
    }
}

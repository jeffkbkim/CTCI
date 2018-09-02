import java.util.Arrays;
public class RotateMatrix {
	void rotateMatrix(int[][] matrix) {
		int N = matrix.length;
		if (N <= 1) return;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++)  {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N - j - 1][i];
				matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
				matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
				matrix[j][N - i - 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			new int[]{1, 2, 3, 4},
			new int[]{5, 6, 7, 8},
			new int[]{9, 10, 11, 12},
			new int[]{13, 14, 15, 16}
		};
		RotateMatrix rm = new RotateMatrix();
		rm.rotateMatrix(matrix);
		for (int[] line: matrix) {
			System.out.println(Arrays.toString(line));
		}
	}

}

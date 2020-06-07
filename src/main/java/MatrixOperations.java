public class MatrixOperations {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    public void flip(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                swap(matrix, i, j, i, matrix[i].length - j - 1);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }
}

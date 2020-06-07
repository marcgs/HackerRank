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

    // level = 0
    // i = 1
    // start = 0
    // end = 4
    public void rotate2(int[][] matrix) {
        int N = matrix.length;
        for (int level = 0; level < matrix.length/2; level++) {
            int start = level;
            int end = N - level;

            for (int i = start; i < end - 1; i++) {
                int first = matrix[start][i];
                int second = matrix[i][end - 1];
                int third = matrix[end - 1][N - 1 - i];
                int fourth = matrix[N - 1 - i][start];

                matrix[start][i] = fourth;
                matrix[i][end - 1] = first;
                matrix[end - 1][N - 1 - i] = second;
                matrix[N - 1 - i][start] = third;

            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }
}

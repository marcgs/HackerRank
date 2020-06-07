import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MatrixOperationsTest {

    private MatrixOperations matrixOperations = new MatrixOperations();

    @Test
    public void transpose_simple_matrix() {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixOperations.transpose(matrix);
        Assertions.assertThat(matrix).isEqualTo(new int[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});
    }

    @Test
    public void flip_simple_matrix() {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixOperations.flip(matrix);
        Assertions.assertThat(matrix).isEqualTo(new int[][] {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}});
    }

    @Test
    public void rotate_simple_matrix() {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixOperations.rotate(matrix);
        Assertions.assertThat(matrix).isEqualTo(new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
    }

    @Test
    public void rotate_bigger_matrix() {
        int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        matrixOperations.rotate(matrix);
        Assertions.assertThat(matrix).isEqualTo(new int[][] {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}});
    }

    @Test
    public void rotate_simple_matrix_2() {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixOperations.rotate2(matrix);
        Assertions.assertThat(matrix).isEqualTo(new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
    }

    @Test
    public void rotate_bigger_matrix_2() {
        int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        matrixOperations.rotate2(matrix);
        Assertions.assertThat(matrix).isEqualTo(new int[][] {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}});
    }
}
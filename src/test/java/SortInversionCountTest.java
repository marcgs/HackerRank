import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class SortInversionCountTest {

    @Test
    public void count_inversions_by_selection_test_1() {
        int[] input = {1, 1, 2, 3};
        long result = SortInversionCount.BySelectionSort.countInversions(input);

        assertThat(input).isEqualTo(new int[]{1, 1, 2, 3});
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void count_inversions_by_selection_test_2() {
        int[] input = {2, 1, 3, 1, 2};
        long result = SortInversionCount.BySelectionSort.countInversions(input);

        assertThat(input).isEqualTo(new int[]{1, 1, 2, 2, 3});
        //assertThat(result).isEqualTo(4);
    }

    @Test
    public void count_inversions_by_merge_test_1() {
        int[] input = {1, 1, 2, 3};
        long result = SortInversionCount.ByMergeSort.countInversions(input);

        assertThat(result).isEqualTo(0);
        assertThat(input).isEqualTo(new int[]{1, 1, 2, 3});
    }

    @Test
    public void count_inversions_by_merge_test_2() {
        int[] input = {2, 1, 3, 1, 2};
        long result = SortInversionCount.ByMergeSort.countInversions(input);

        assertThat(input).isEqualTo(new int[]{1, 1, 2, 2, 3});
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void count_inversions_by_merge_test_3() {
        int[] input = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        long result = SortInversionCount.ByMergeSort.countInversions(input);

        assertThat(input).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertThat(result).isEqualTo(36);
    }

    @Test
    public void count_inversions_by_merge_test_big_test() throws FileNotFoundException {
        TestCaseRunner runner = new TestCaseRunner("SortInversionCount-input-07.txt");
        long[] results = runner.execute();

        assertThat(results).isEqualTo(new long[]{0, 0, 0, 4999950000L, 4999950000L});
    }

    public static class TestCaseRunner {
        private final Scanner scanner;

        public TestCaseRunner(String file) throws FileNotFoundException {
            scanner = new Scanner(this.getClass().getResourceAsStream(file));
        }

        public long[] execute() {
            int t = scanner.nextInt();
            long[] results = new long[t];

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] arr = new int[n];

                String[] arrItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int arrItem = Integer.parseInt(arrItems[i]);
                    arr[i] = arrItem;
                }

                results[tItr] = SortInversionCount.ByMergeSort.countInversions(arr);
            }

            return results;
        }
    }

}
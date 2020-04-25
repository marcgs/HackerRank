import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class SortInversionCountTest {

    @Test
    public void count_inversions_test_1() {
        int[] input = {1, 1, 2, 3};
        long result = SortInversionCount.BySelectionSort.countInversions(input);

        assertThat(result).isEqualTo(0);
        System.out.println(Arrays.toString(input));
    }

    @Test
    public void count_inversions_test_2() {
        int[] input = {2, 1, 3, 1, 2};
        long result = SortInversionCount.BySelectionSort.countInversions(input);

        assertThat(result).isEqualTo(4);
        System.out.println(Arrays.toString(input));
    }

}
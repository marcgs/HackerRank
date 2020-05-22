import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInRotatedArrayTest {

    @Test
    public void find_offset_case_1() {
        int result = SearchInRotatedArray.findOffset(new int[]{1, 2, 3, 4, 5}, 0, 5);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void find_offset_case_2() {
        int result = SearchInRotatedArray.findOffset(new int[]{5, 1, 2, 3, 4}, 0, 5);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void find_offset_case_3() {
        int result = SearchInRotatedArray.findOffset(new int[]{4, 5, 1, 2, 3}, 0, 5);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void find_offset_case_4() {
        int result = SearchInRotatedArray.findOffset(new int[]{3, 4, 5, 1, 2}, 0, 5);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void find_offset_case_5() {
        int result = SearchInRotatedArray.findOffset(new int[]{2, 3, 4, 5, 1}, 0, 5);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void search_case_3_elements() {
        int result = SearchInRotatedArray.search(new int[]{2, 3, 1}, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void search_case_10_elements() {
        int result = SearchInRotatedArray.search(new int[]{5, 7, 10, 33, 45, 55, 123, 1, 3, 4}, 55);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void search_case_10_elements_sorted() {
        int result = SearchInRotatedArray.search(new int[]{1, 3, 4, 5, 7, 10, 33, 45, 55, 123}, 55);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void search_case_3_elements_not_found() {
        int result = SearchInRotatedArray.search(new int[]{2, 3, 1}, 4);
        assertThat(result).isLessThan(0);
    }
}
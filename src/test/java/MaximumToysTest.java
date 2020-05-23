import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumToysTest {

    @Test
    public void zero_toys() {
        int[] prices = {1, 2, 3, 4, 5};
        int result = MaximumToys.maximumToys(prices, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void one_toy() {
        int[] prices = {1, 2, 3, 4, 5};
        int result = MaximumToys.maximumToys(prices, 2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void two_toys() {
        int[] prices = {1, 2, 3, 4, 5};
        int result = MaximumToys.maximumToys(prices, 4);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void three_toys() {
        int[] prices = {1, 2, 3, 4, 5};
        int result = MaximumToys.maximumToys(prices, 7);
        assertThat(result).isEqualTo(3);
    }
}
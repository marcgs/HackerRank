import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ElectronicsShopTest {

    @Test
    public void electronics_test_case_1() {
        assertThat(ElectronicsShop.getMoneySpent(new int[]{3,1}, new int[]{5,2,8}, 9)).isEqualTo(9);
    }
}
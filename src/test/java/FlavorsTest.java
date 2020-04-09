import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class FlavorsTest {

    @Test
    public void flavors_test_case_2() {
        assertThat(Flavors.whatFlavors(new int[]{4, 3, 2, 5, 7}, 8)).isEqualTo("2 4");
        assertThat(Flavors.whatFlavors(new int[]{7, 2, 5, 4, 11}, 12)).isEqualTo("1 3");
    }
}
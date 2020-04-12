import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class RoadsAndLibrariesTest {

    @Test
    public void testcase1() {
        long cost = RoadsAndLibraries.roadsAndLibraries(3, 2, 1,
                new int[][]
                        {
                                {1, 2},
                                {3, 1},
                                {2, 3},
                        }
        );

        assertThat(cost).isEqualTo(4);
    }

    @Test
    public void testcase2() {
        long cost = RoadsAndLibraries.roadsAndLibraries(6, 2, 5,
                new int[][]
                        {
                                {1, 3},
                                {3, 4},
                                {2, 4},
                                {1, 2},
                                {2, 3},
                                {5, 6},
                        }
        );

        assertThat(cost).isEqualTo(12);
    }
}
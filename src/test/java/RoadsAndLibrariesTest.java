import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    public void testcase3() {
        long cost = RoadsAndLibraries.roadsAndLibraries(6, 5, 2,
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

        assertThat(cost).isEqualTo(18);
    }

    @Test
    public void testcase4() {
        long cost = RoadsAndLibraries.roadsAndLibraries(9, 5, 2,
                new int[][]
                        {
                                {1, 3},
                                {3, 4},
                                {2, 4},
                                {1, 2},
                                {2, 3},
                                {5, 6},
                                {7, 8},
                                {8, 9}
                        }
        );

        assertThat(cost).isEqualTo(27);
    }



    @Test
    public void bigtestcase1() throws FileNotFoundException {
        TestCaseRunner runner = new TestCaseRunner("roadsAndLibraries-input03.txt");
        TestOutputReader reader = new TestOutputReader("roadsAndLibraries-output03.txt");

        long[] actual = runner.execute();
        long[] expected = reader.readOutput();

        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));

        assertThat(actual).isEqualTo(expected);
    }

    public static class TestCaseRunner {
        private final Scanner scanner;

        public TestCaseRunner(String file) throws FileNotFoundException {
            scanner = new Scanner(this.getClass().getResourceAsStream(file));
        }

        public long[] execute() {
            int q = scanner.nextInt();
            long[] results = new long[q];

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String[] nmC_libC_road = scanner.nextLine().split(" ");

                int n = Integer.parseInt(nmC_libC_road[0]);

                int m = Integer.parseInt(nmC_libC_road[1]);

                int c_lib = Integer.parseInt(nmC_libC_road[2]);

                int c_road = Integer.parseInt(nmC_libC_road[3]);

                int[][] cities = new int[m][2];

                for (int i = 0; i < m; i++) {
                    String[] citiesRowItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < 2; j++) {
                        int citiesItem = Integer.parseInt(citiesRowItems[j]);
                        cities[i][j] = citiesItem;
                    }
                }

                results[qItr] = RoadsAndLibraries.roadsAndLibraries(n, c_lib, c_road, cities);
            }

            return results;
        }
    }

    public static class TestOutputReader {
        private final Scanner scanner;

        public TestOutputReader(String file) throws FileNotFoundException {
            scanner = new Scanner(this.getClass().getResourceAsStream(file));
        }

        public long[] readOutput() {
            List<Long> output = new ArrayList<>();
            while(scanner.hasNextLong()) {
                output.add(scanner.nextLong());
            }
            return output.stream().mapToLong(i->i).toArray();
        }
    }
}
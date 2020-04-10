import java.util.Arrays;
import java.util.List;

/**
 * From https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 */
public class Flavors {


    // Complete the whatFlavors function below.
    static String whatFlavors(int[] cost, int money) {
        int[] scost = Arrays.stream(cost).sorted().toArray();

        for (int index1 = 0; index1 < cost.length; index1++) {
            int costItem1 = cost[index1];
            int costItem2 = money - costItem1;

            if (Arrays.binarySearch(scost, costItem2) >= 0) {
                int index2 = indexOf(cost, costItem2, index1);
                if (index2 > 0) {
                    int first = Math.min(index1, index2) + 1;
                    int second = Math.max(index1, index2) + 1;
                    return first + " " + second;
                }
            }
        }

        return null;
    }

    static int indexOf(int[] input, int element, int indexToSkip) {
        for (int i = 0; i < input.length; i++) {
            if (i != indexToSkip && input[i] == element) {
                return i;
            }
        }
        return -1;
    }


}

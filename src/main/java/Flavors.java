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
            int desiredCost = money - cost[index1];
            if (Arrays.binarySearch(scost, desiredCost) >= 0) {
                int index2 = indexOf(cost, desiredCost, index1);
                if (index2 > 0) {
                    int first = Math.min(index1, index2) + 1;
                    int second = Math.max(index1, index2) + 1;
                    return first + " " + second;
                }
            }
        }

        return null;
    }

    static int indexOf(int[] input, int element, int indexToStart) {
        for (int i = indexToStart + 1; i < input.length; i++) {
            if (input[i] == element) {
                return i;
            }
        }
        return -1;
    }


}

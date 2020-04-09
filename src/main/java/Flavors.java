import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

/**
 * From https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 */
public class Flavors {

    static class CostItem {
        private int cost;
        private int index;

        public CostItem(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }

    // Complete the whatFlavors function below.
    static String whatFlavors(int[] cost, int money) {
        CostItem[] costItems = IntStream.range(0, cost.length)
                .mapToObj(i -> new CostItem(cost[i], i+1))
                .filter(c -> c.cost < money)
                .sorted(comparingInt(c -> c.cost))
                .toArray(CostItem[]::new);
                //.collect(Collectors.toList());


        for (int i = 0; i < costItems.length; i++) {
            for (int j = i + 1; j < costItems.length; j++) {
                int sum = costItems[i].cost + costItems[j].cost;
                if (sum == money) {
                    int[] indexes = {costItems[i].index, costItems[j].index};
                    int[] sortedIndexes = Arrays.stream(indexes).sorted().toArray();
                    System.out.println(sortedIndexes[0] + " " + sortedIndexes[1]);
                    return sortedIndexes[0] + " " + sortedIndexes[1];
                } else if (sum > money) {
                    break;
                }
            }

        }

        return null;
    }


}

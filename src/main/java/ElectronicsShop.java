import java.util.Arrays;
import java.util.stream.IntStream;

public class ElectronicsShop {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int closestDif = Integer.MAX_VALUE;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                int dif = b - (keyboards[i] + drives[j]);
                if (dif >= 0 && dif < closestDif) {
                    closestDif = dif;
                }
            }
        }

        return closestDif != Integer.MAX_VALUE ? b - closestDif : -1;
    }

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpentOptimized(int[] keyboards, int[] drives, int b) {
        Arrays.sort(keyboards);
        Arrays.sort(drives);

        int closestDif = Integer.MAX_VALUE;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = drives.length - 1; j >= 0; j--) {
                int dif = b - (keyboards[i] + drives[j]);
                if (dif >= 0 && dif < closestDif) {
                    closestDif = dif;
                    break;
                }
            }
        }

        return closestDif != Integer.MAX_VALUE ? b - closestDif : -1;
    }

}

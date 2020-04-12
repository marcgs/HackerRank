import java.io.*;
import java.util.*;

/**
 * From https://www.hackerrank.com/challenges/torque-and-development/problem
 */
public class RoadsAndLibraries {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib <= c_road) {
            return c_lib * n;
        }

        // calculate adjacent matrix
        boolean[][] adjMatrix = new boolean[n][n];
        for (int i = 0; i < cities.length; i++) {
            int first = cities[i][0] - 1;
            int second = cities[i][1] - 1;
            adjMatrix[first][second] = true;
            adjMatrix[second][first] = true;
        }

        // calculate cost
        long connectedComponents = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjMatrix, visited);
                connectedComponents++;
            }
        }

        return (long) c_road * (n - connectedComponents) + (long) c_lib * connectedComponents;
    }

    static int dfs(int index, boolean[][] adjMatrix, boolean[] visited) {
        int amount = 1;
        visited[index] = true;
        for (int i = 0; i < adjMatrix[index].length; i++) {
            if (!visited[i] && adjMatrix[index][i]) {
                amount += dfs(i, adjMatrix, visited);
            }
        }
        return amount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
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

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class SortInversionCount {

    public static class BySelectionSort {
        // Complete the countInversions function below.
        static long countInversions(int[] arr) {
            long inversions = 0;
            for (int i = 0; i < arr.length; i++) {
                int min = i;
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }

                if (arr[i] > arr[min]) {
                    int tmp = arr[min];
                    arr[min] = arr[i];
                    arr[i] = tmp;

                    inversions += min - i;
                }
            }

            return inversions;
        }

    }

}


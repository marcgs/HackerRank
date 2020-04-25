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


    public static class ByMergeSort {
        // Complete the countInversions function below.
        static long countInversions(int[] arr) {
            long inversions = 0;
            return mergeSort(arr, 0, arr.length);
        }

        static long mergeSort(int[] arr, int start, int end) {
            if (end - start < 2) {
                return 0;
            }

            int mid = (start + end)/2;
            long leftInversions = mergeSort(arr, start, mid);
            long rightInversions = mergeSort(arr, mid, end);

            int[] left = Arrays.copyOfRange(arr, start, mid);
            int[] right = Arrays.copyOfRange(arr, mid, end);

            long mergeInversions = 0;
            int k = start, i = 0, j = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    mergeInversions += left.length - i;
                    arr[k++] = right[j++];
                }
            }

            while (i < left.length) {
                arr[k++] = left[i++];
            }

            while (j < right.length) {
                arr[k++] = right[j++];
            }

            return leftInversions + rightInversions + mergeInversions;
        }
    }

}


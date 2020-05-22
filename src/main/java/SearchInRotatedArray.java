import java.util.Arrays;

public class SearchInRotatedArray {

    public static int search(int[] arr, int item) {
        int pivotIdx = findOffset(arr, 0, arr.length);
        if (item >= arr[0]) {
            return Arrays.binarySearch(arr, 0, pivotIdx, item);
        }
        return Arrays.binarySearch(arr, pivotIdx, arr.length, item);
    }

    public static int findOffset(int[] arr, int start, int end) {
        int mid = (start + end)/2;
        if (start == end - 1) {
            return end % arr.length;
        }

        if (arr[start] > arr[mid]) {
            return findOffset(arr, start, mid);
        }
        return findOffset(arr, mid, end);
    }

}


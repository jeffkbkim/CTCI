import java.util.*;
public class Mergesort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 5, 7, 13, 2, 20, 9, 5, 18};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergesort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    private static void mergesort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergesort(arr, start, mid);
        mergesort(arr, mid + 1, end);
        merge(arr, start, mid + 1, end);
    }

    private static void merge(int[] arr, int l_start, int r_start, int end) {
        int[] temp = new int[end - l_start + 1];
        int left = l_start, l_end = r_start - 1, right = r_start, k = 0;
        while (left <=  l_end && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left];
                left++;
            } else {
                temp[k] = arr[right];
                right++;
            }
            k++;
        }
        System.arraycopy(arr, left, temp, k, l_end - left + 1);
        System.arraycopy(arr, right, temp, k, end - right + 1);
        System.arraycopy(temp, 0, arr, l_start, end - l_start + 1);
        
    }
}
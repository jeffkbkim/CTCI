public class Bubblesort {
    public void bubblesort(int[] nums) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            int lastIndex = nums.length - 1;
            for (int i = 0; i < lastSorted; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, j);
                    isSorted = false;
                }
            }
            lastIndex--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
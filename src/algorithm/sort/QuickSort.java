package algorithm.sort;

/**
 * Created by chaiyuze on 2018/9/4.
 */
public class QuickSort {

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int q = partition(nums, lo, hi);
            quickSort(nums, lo, q - 1);
            quickSort(nums, q + 1, hi);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < nums[lo]) {
                if (i == hi) {
                    break;
                }
            }

            while (nums[--j] > nums[lo]) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        int tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = tmp;

        return j;
    }

}

package leetcode.top100;

/**
 * @author chaiyuze
 * @since 2018/11/5
 */
public class Median2SortedArr {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * You may assume nums1 and nums2 cannot be both empty.

     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * The median is 2.0

     * Example 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * The median is (2 + 3)/2 = 2.5
     */

    class Solution {

        /**
         * 一开始的思路：类似于归并排序的"并"步骤，将两个数组合并。但是只需要合并到"一半"即可，而且不需要真的把已合并的部分记录起来。
         * 记 len1 + len2 = N
         * 当 N 为奇数时，取 c[(N - 1) / 2]
         * 当 N 为偶数时，取 avg(c[N / 2 - 1], c[N / 2])
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;

            int i = 0, j = 0;
            while (i + j <= len / 2) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            if ((len & 1) == 1) {
                return nums1[i] > nums2[j] ? nums1[i] : nums2[j];
            } else {
                return (double) (nums1[i] + nums2[j]) / 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Median2SortedArr().new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(new Median2SortedArr().new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
    }

}

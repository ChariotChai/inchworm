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
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            return 0d;
        }

    }

}

public class TowSum {

    /**
     * Problem:
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
       You may assume that each input would have exactly one solution, and you may not use the same element twice.
       Example:
       Given nums = [2, 7, 11, 15], target = 9,
       Because nums[0] + nums[1] = 2 + 7 = 9,
       return [0, 1].
     */

    /**
     * 这道题不难，但是需要注意认真审题。。。数字是可以为负的，所以 target < pivot 的条件优化就免了吧。
     * 下面的结果是4ms，99.32%
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int pivot = nums[i];
                Integer residualKey = m.get(target - pivot);
                if (residualKey != null) {
                    return new int[]{residualKey, i};
                } else {
                    m.put(pivot, i);
                }
            }
            return null;
        }
    }

    /**
     * 下面这个结果是2ms的参考，和我的思路比较像，都是判断补数是否存在。不过这个方法抛弃了Map，采用了更暴力的方法。
     * 另外，发现很多答案竟然会先排序，我也是有点懵逼。。。想不通的是一个3ms的答案竟然也是先排序。我和这个2ms都是O(N)的复杂度，但凡排序都是O(NlogN)起步吧？可能是test case有些短？
     */
    class SolutionReference1 {
        public int[] twoSum(int[] nums, int target) {
        int max = 2048;
        int[] indexes = new int[max];
        int bitMode = --max;
        int first = nums[0];
    
        for (int i = 1; i < nums.length; i++) {
          int difference = target - nums[i];
          if (difference == first) {
            return new int[]{0, i};
          }
          int index = indexes[difference&bitMode];
          if(index != 0) {
            return new int[]{index, i};
          }
          indexes[nums[i]&bitMode] = i;
        }
        return new int[0];
      }
    }

}
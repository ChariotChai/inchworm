import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringWithOutRepeatingCharacters {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    class Solution {

        /**
        * 直接看到这道题，完全没有思路，能想到的都是O(N^2)的做法。
        * 求助一下场外观众吧。。。
        *
        * 看了答案之后发现原来的思路做下来应该就是 Sliding Window 的做法，其实复杂度是O(2N)
        * 答案3的 Optimizing Sliding Window 才是正中要害。
        * 答案4其实能够通过答案3自然而然想到。
        * */
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> cPos = new HashMap<>();
            int res = 0;
            int len = s.length();

            //还需要细想一下下面的处理
            for (int i = 0, k = 0; i < len; i++) {
                Integer lastPos = cPos.get(s.charAt(i));
                if (lastPos != null) {
                    k = lastPos > k ? lastPos : k;
                }
                cPos.put(s.charAt(i), i + 1);
                res = res > i - k + 1 ? res : i - k + 1;
            }
            return res;
        }

        public int lengthOfLongestSubstring_(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        System.out.println(new LongestStringWithOutRepeatingCharacters().new Solution().lengthOfLongestSubstring("dvdf"));
    }

}

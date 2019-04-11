package com.chariot.inchworm.leetcode.top100;


public class RegularExpressionMatching {

    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     *
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like . or *.
     * Example 1:
     *
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     *
     * Input:
     * s = "aa"
     * p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     * Example 3:
     *
     * Input:
     * s = "ab"
     * p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     * Example 4:
     *
     * Input:
     * s = "aab"
     * p = "c*a*b"
     * Output: true
     * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
     * Example 5:
     *
     * Input:
     * s = "mississippi"
     * p = "mis*is*p*."
     * Output: false
     */

    class Solution {

        /**
         * 直觉是双指针法。。。
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {
            return true;
        }
    }

    public static void main(String[] args) {
        int cc = 0;
        int dd = 0;
        for (int i = 0; i < 100000; i++) {
            if (String.valueOf(i).contains("8")) cc++;
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                if (String.valueOf(i).charAt(j) == '8') dd++;
            }
        }
        System.out.println(cc);
        System.out.println(dd);
    }

}

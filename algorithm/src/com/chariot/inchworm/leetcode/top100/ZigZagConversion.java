package com.chariot.inchworm.leetcode.top100;

public class ZigZagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */

    class Solution {

        public String convert(String s, int numRows) {
            if (s == null || s.length() <= numRows || numRows == 1) {
                return s;
            }

            StringBuilder sb = new StringBuilder();
            int interval = 2 * (numRows - 1);
            for (int col = 0; col < numRows; col++) {
                for (int pivot = col; pivot < s.length(); pivot += interval) {
                    sb.append(s.charAt(pivot));

                    if (col != 0 && col != numRows - 1) {
                        int pivot2 = pivot + 2 * (numRows - col - 1);
                        if (pivot2 < s.length()) {
                            sb.append(s.charAt(pivot2));
                        }
                    }
                }
            }
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion(). new Solution().convert("PAYPALISHIRING", 2));
    }

}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chaiyuze on 2018/9/2.
 */
public class Solution_ABC {

    /**
     * 717. 1-bit and 2-bit Characters
     * 只要判断最后一个0与倒数第2个0之间1的个数的奇偶性即可
     * 前面数组长度的判断可以提高执行效率
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1 || bits[bits.length - 2] == 0) {
            return true;
        }

        int cnt = 0;

        for (int i = bits.length - 2; i >= 0; i--) {
            if (bits[i] == 0) {
                break;
            }

            cnt++;
        }

        return (cnt & 1) == 0;
    }

    /**
     * 67. Add Binary
     * 注意陷阱！用int或者long来做加法都不行，因为题目没有说这个序列的长度
     *
     * 高效率的例子中，利用了String.toCharArray()与String.valueOf(char[])
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] charA, charB;
        if (a.length() > b.length()) {
            charA = a.toCharArray();
            charB = b.toCharArray();
        } else {
            charA = b.toCharArray();
            charB = a.toCharArray();
        }

        int indexA = charA.length - 1;
        int indexB = charB.length - 1;
        int c = 0;
        int s = 0;
        int sum = 0;

        //这里可以进一步优化，对于A远大于B的情况。
        while (indexA >= 0) {
            if (indexB >= 0) {
                sum = charA[indexA] - '0' + charB[indexB] - '0' + c;
            } else {
                sum = charA[indexA] - '0' + c;
            }

            c = sum >> 1;
            s = sum & 1;

            charA[indexA] = (char)('0' + s);
            indexA--;
            indexB--;
        }

        if (c != 0) {
            return "1" + String.valueOf(charA);
        } else {
            return String.valueOf(charA);
        }

    }

    /**
     * 258. Add Digits
     * 这题解法着实精妙！
     * 用到了数字根的定义。一个数+9后数字根不变（十位+1，个位-1）
     * https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
     * 还发现，如果下面算了两次模9，效率会远低于一次。
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }

    /**
     * 415. Add Strings
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    /**
     * 441. Arranging Coins
     * 题目是比较简单啦，但是注意几个细节：
     * 一是*8时可能导致int型的溢出
     * 而是向下取整可以直接用强制类型转换
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(1 + 8L * n) / 2 - 0.5);
    }

    /**
     * 561. Array Partition I
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[i<<1];
        }
        return sum;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 637. Average of Levels in Binary Tree
     * 层次遍历二叉树，队列是个好做法
     * ArrayList和LinkedList区别真的很大
     * poll()和remove(0)效率区别也很大
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            double layerSum = 0;
            int layerCnt = nodes.size();

            for (int i = 0; i < layerCnt; i++) {
                TreeNode node = nodes.poll();
                layerSum += node.val;
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

            result.add(layerSum / layerCnt);
        }

        return result;
    }

    /**
     * 844. Backspace String Compare
     * 一开始用了队列去做这件事，结果效率很低。。。其实是有些高举高打，没有从问题本质下手
     * 用双指针法解决这个问题比较好
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Queue<Character> q = new LinkedList<>();
        char[] cs = S.toCharArray();
        int ign = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '#') {
                ign++;
            } else {
                if (ign > 0) {
                    ign--;
                } else {
                    q.add(cs[i]);
                }
            }
        }

        char[] ct = T.toCharArray();
        ign = 0;
        for (int i = ct.length - 1; i >= 0; i--) {
            if (ct[i] == '#') {
                ign++;
            } else {
                if (ign > 0) {
                    ign--;
                } else {
                    if (ct[i] != q.poll()) {
                        return false;
                    }
                }
            }
        }

        return q.isEmpty();
    }

    /**
     * 504. Base 7
     * 最鸡贼的是 Integer.toString(num, 7);
     * 底层库的实现中，考虑到2进制的int最多32位，考虑正负性，一个长度33的char数组即可满足，不需要StringBuilder
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        boolean neg = num < 0;
        StringBuilder sb = new StringBuilder();

        int q = neg ? - num : num;

        do {
            sb.insert(0, q % 7);
            q /= 7;
        } while (q != 0);

        if (neg) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    /**
     * 110. Balanced Binary Tree
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        treeDepth(root);
        return isBalance;
    }
    private boolean isBalance;
    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            isBalance = false;
        }

        return left > right ? left + 1 : right + 1;
    }

    /**
     * 682. Baseball Game
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];

            if ("C".equals(op)) {
                sum -= stack.pop();
            }

            else if ("D".equals(op)) {
                int v = stack.peek() * 2;
                stack.push(v);
                sum += v;
            }

            else if ("+".equals(op)) {
                int o1 = stack.pop();
                int o2 = stack.peek() + o1;
                stack.push(o1);
                stack.push(o2);
                sum += o2;
            }

            else {
                int v = Integer.parseInt(op);
                stack.push(v);
                sum += v;
            }
        }

        return sum;
    }

    /**
     * 121. Best Time to Buy and Sell Stock
     * 关键是寻找局部点
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int profit = 0;
        int buy = 0;
        int sell = 0;
        int p = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > p) {
                sell = prices[i];
//                if (s)
            }

        }

        return profit;
    }

    public boolean hasAlternatingBits(int n) {
        int v = 1 + n + (n>>1);
        return (v & (v - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_ABC().hasAlternatingBits(7));
    }

}

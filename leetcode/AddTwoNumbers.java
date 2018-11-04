public class AddTwoNumbers {

    /*
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 通过这道题发现。。。leetcode（起码是java）的跑分方差好大额。。。同一个代码两次提交分别是60%和90%的样子。
     * 这道题虽然是medium，但是也不难啦。开始有对长度差别很大的两个数组做了优化，结果跑分时发现还不如普通的方法，令人气馁。
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum, currVal, carry = 0;
            ListNode head = new ListNode(-1);
            ListNode currNode = head;

            while (l1 != null || l2 != null) {
                sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                currVal = sum >= 10 ? sum - 10 : sum;
                carry = sum >= 10 ? 1 : 0;
                currNode.next = new ListNode(currVal);

                currNode = currNode.next;
            }

            if (carry != 0) {
                currNode.next = new ListNode(carry);
            }

            return head.next;
        }
    }

}
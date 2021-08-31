//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 👍 1535 👎 0


package com.genie.linkedlist;

public class _019_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new _019_RemoveNthNodeFromEndOfList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //方案1 先遍历取得length 然后遍历到length-n;
            //方案2 快慢指针，快指针先走到n时，然后慢指针开始从开头走,当快指针走到最后时，慢指针正好走到n
            ListNode pre = new ListNode(0, head);
            ListNode cur = pre;
            int length = getLength(head);
            for (int i = 0; i < length - n; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return pre.next;
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                ++length;
                head = head.next;
            }
            return length;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //方案1 先遍历取得length 然后遍历到length-n;
            //方案2 快慢指针，快指针先走到n时，然后慢指针开始从开头走,当快指针走到最后时，慢指针正好走到n
            ListNode pre = new ListNode(0, head);
            ListNode cur = pre;
            int length = getLength(head);
            for (int i = 0; i < length - n; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return pre.next;
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                ++length;
                head = head.next;
            }
            return length;
        }
    }
}
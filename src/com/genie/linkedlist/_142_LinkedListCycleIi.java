//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，
//pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 哈希表 链表 双指针 👍 1139 👎 0


package com.genie.linkedlist;

public class _142_LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new _142_LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        class ListNode {
            int val;
            ListNode next;

            public ListNode(int x) {
                val = x;
                next = null;
            }
        }

        public ListNode detectCycle(ListNode head) {
            /**画图  a+x(b+c)+b = 2(a+b)
             *      a + xb + xc + b = 2 a + 2 b
             *      xb - 1 b + xc = a
             *      (x - 1) (b + c) + c = a
             */
            ListNode s = head;
            ListNode f = head;
            while (f != null && f.next != null) {
                f = f.next.next;
                s = s.next;
                if (s == f) {
                    break;
                }
            }
            if (f == null || f.next == null) return null;
            f = head;
            while (f != s) {
                s = s.next;
                f = f.next;
            }
            return f;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
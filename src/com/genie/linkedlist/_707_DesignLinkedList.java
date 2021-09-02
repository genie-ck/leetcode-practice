//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 👍 281 👎 0


package com.genie.linkedlist;

public class _707_DesignLinkedList {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        class ListNode {
            int val;
            ListNode next;
            ListNode prev;

            public ListNode(int val) {
                this.val = val;
            }
        }

        int size;
        ListNode head;
        ListNode tail;


        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            ListNode cur = head;
            //如果小于1/2 那么就从前往后，
            if (index < size / 2) {
                while (index >= 0) {
                    index--;
                    cur = cur.next;
                }
            } else {
                cur = tail;
                int x = size - index;
                while (x > 0) {
                    x--;
                    cur = cur.prev;
                }
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode pred = head, cur = head.next;
            ListNode toAdd = new ListNode(val);
            toAdd.prev = pred;
            toAdd.next = cur;
            pred.next = toAdd;
            cur.prev = toAdd;
            ++size;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode cur = tail, pred = tail.prev;
            ListNode toAdd = new ListNode(val);
            toAdd.prev = pred;
            toAdd.next = cur;
            pred.next = toAdd;
            cur.prev = toAdd;
            ++size;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index < 0) index = 0;
            ListNode pred, succ;
            if (index < size / 2) {
                pred = head;
                while (index > 0) {
                    index--;
                    pred = pred.next;
                }
                succ = pred.next;
            } else {
                succ = tail;
                int x = size - index;
                while (x > 0) {
                    x--;
                    succ = succ.prev;
                }
                pred = succ.prev;
            }
            ++size;
            ListNode toAdd = new ListNode(val);
            toAdd.prev = pred;
            toAdd.next = succ;
            pred.next = toAdd;
            succ.prev = toAdd;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode pred, succ;
            if (index < size / 2) {
                pred = head;
                while (index > 0) {
                    index--;
                    pred = pred.next;
                }
                succ = pred.next.next;
            } else {
                succ = tail;
                int x = size - index;
                while (x > 1) {
                    x--;
                    succ = succ.prev;
                }
                pred = succ.prev.prev;
            }
            --size;
            pred.next = succ;
            succ.prev = pred;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
//leetcode submit region end(Prohibit modification and deletion)
    class MyLinkedList2 {
        class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }

        int size;
        ListNode head;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList2() {
            this.size = 0;
            head = new ListNode(0);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            ListNode cur = head;
            //get 0 就是往后一步，以此类推，但不能大于size;
            for (int i = 0; i < index + 1; ++i) {
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            //数量加1,得先走到index的前一个,然后新建一个listnode 把后继指向pre的后继,然后把pre的后继指向新建的listnode
            ++size;
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            //走到前一个,然后把pre的next 指向pre的next的next;
            --size;
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
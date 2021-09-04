//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 1588 👎 0


package com.genie.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class _146_LruCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        private Map<Integer, Node> cache;
        Node head;
        Node tail;
        int capacity;
        int size;

        public LRUCache(int capacity) {
            cache = new HashMap<>(capacity);
            this.capacity = capacity;
            size = 0;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            //从map中获取，如果没有则返回-1，有的话需要移动到头
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            removeNode(node);
            addToHead(node);
            return node.value;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void addToHead(Node node) {
            Node next = head.next;
            node.prev = head;
            node.next = next;
            next.prev = node;
            head.next = node;
        }

        public Node removeTail() {
            //虚拟尾部的前一个就是要删掉的
            Node node = tail.prev;
            removeNode(node);
            return node;
        }

        public void put(int key, int value) {
            //塞的时候，先取有没有 有的话就更新节点的value，并移到最前面
            //如果没有 那么就新建一个节点,然后加到链表头，map中维护新的key,node，加完如果大于限制个数了，那么删掉尾部
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                removeNode(node);
                addToHead(node);
            } else {
                Node newNode = new Node(key, value);
                addToHead(newNode);
                cache.put(key, newNode);
                ++size;
                if (size > capacity) {
                    Node last = removeTail();
                    cache.remove(last.key);
                    --size;
                }
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
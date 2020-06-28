package LeetCode.first_0301;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU缓存
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache( 2  capacity (缓存容量)  )
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回 1
 * cache.put(3, 3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4, 4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 */
public class Hard_460 {

    private int maxfreq = 1;
    private int capacity;
    private Map<Integer, ListNode> key_table;
    private Map<Integer, DoubleLinkedList> freq_table;

    private static class ListNode {
        private int key;
        private int value;
        private int freq = 1;
        private ListNode pre;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoubleLinkedList {
        /**
         * 虚拟头结点，它无前驱结点
         */
        private ListNode dummyHead;
        /**
         * 虚拟尾结点，它无后继结点
         */
        private ListNode dummyTail;

        /**
         * 当前双向链表的有效结点数
         */
        private int count;

        public DoubleLinkedList() {
            this.dummyHead = new ListNode();
            this.dummyTail = new ListNode();

            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            count = 0;
        }

        public void addNode2Head(ListNode addNode) {
            ListNode oldHead = dummyHead.next;
            // 两侧结点指向它
            dummyHead.next = addNode;
            oldHead.pre = addNode;
            // 它的前驱和后继指向两侧结点
            addNode.pre = dummyHead;
            addNode.next = oldHead;
            count++;
        }

        public ListNode removeTail() {
            ListNode oldTail = dummyTail.pre;
            ListNode newTail = oldTail.pre;

            // 两侧结点建立连接
            newTail.next = dummyTail;
            dummyTail.pre = newTail;

            // 它的两个属性切断连接
            oldTail.pre = null;
            oldTail.next = null;
            count--;
            return oldTail;
        }

    }

    public Hard_460(int capacity) {
        this.capacity = capacity;
        key_table = new HashMap<>(capacity);
        freq_table = new HashMap<>();

    }

    /**
     * get元素
     * @param key
     * @return
     */
    public int get(int key) {
        if (capacity == 0 || !key_table.containsKey(key)) {
            return -1;
        } else {
            // 获得key对应的结点类
            ListNode listNode = removeListNode(key);
            // 挂接到新的访问次数的双向链表的头部
            addListNode2Head(listNode.freq, listNode);
            return listNode.value;
        }

    }

    private ListNode removeListNode(int key) {
        // 获得结点类
        ListNode deleteNode = key_table.get(key);
        ListNode preNode = deleteNode.pre;
        ListNode nextNode = deleteNode.next;
        // 两侧结点建立连接
        preNode.next = nextNode;
        nextNode.pre = preNode;
        // 删除去原来两侧结点的连接
        deleteNode.pre = null;
        deleteNode.next = null;
        // 维护双链表结点数
        freq_table.get(deleteNode.freq).count--;
        // 访问次数加 1
        deleteNode.freq++;
        //更新maxfreq
        maxfreq = Math.max(maxfreq, deleteNode.freq);
        return deleteNode;
    }

    /**
     * 把结点放在对应访问次数的双向链表的头部
     * @param freq
     * @param listNode
     */
    private void addListNode2Head(int freq, ListNode listNode) {
        // 如果不存在，就初始化
        DoubleLinkedList doubleLinkedList = freq_table.containsKey(freq)? freq_table.get(freq) : new DoubleLinkedList();
        doubleLinkedList.addNode2Head(listNode);
        freq_table.put(freq, doubleLinkedList);
    }


    public void put(int key, int value) {
        // 如果 key 存在，就更新访问次数 + 1，更新值
        if (key_table.containsKey(key)) {
            ListNode listNode = removeListNode(key);
            // 更新 value
            listNode.value = value;
            addListNode2Head(listNode.freq, listNode);
        } else {
            //如果key不存在
            // 1、如果满了，先删除访问次数最小的的末尾结点，再删除 map 里对应的 key
            if (key_table.size() == capacity) {
                for (int i = 1; i <= maxfreq; i++) {
                    if (freq_table.containsKey(i) && freq_table.get(i).count > 0) {
                        // 1、从双链表里删除结点
                        DoubleLinkedList doubleLinkedList = freq_table.get(i);
                        ListNode removeNode = doubleLinkedList.removeTail();
                        // 2、删除 map 里对应的 key
                        key_table.remove(removeNode.key);
                        break;
                    }
                }
            }
            // 2、再创建新结点放在访问次数为 1 的双向链表的前面
            ListNode newListNode = new ListNode(key, value);
            addListNode2Head(1, newListNode);
            key_table.put(key, newListNode);
        }
    }

    public static void main(String[] args) {
        Hard_460 cache = new Hard_460(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);

        int res1 = cache.get(4);
        System.out.println(res1);

        int res2 = cache.get(3);
        System.out.println(res2);

        int res3 = cache.get(2);
        System.out.println(res3);

        int res4 = cache.get(1);
        System.out.println(res4);

        cache.put(5, 5);

        int res5 = cache.get(1);
        System.out.println(res5);

        int res6 = cache.get(2);
        System.out.println(res6);

        int res7 = cache.get(3);
        System.out.println(res7);

        int res8 = cache.get(4);
        System.out.println(res8);

        int res9 = cache.get(5);
        System.out.println(res9);

    }
}

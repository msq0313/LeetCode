package Cache.LRUCache;

import java.util.HashMap;

/*
面试题 16.25. LRU缓存
设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，
并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。

它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用
的数据值，从而为新的数据值留出空间。
 */
public class LRUCache {
    // key,value双向链表节点
    public static class Node {
        public int key, value;
        Node next, pre;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // 使用哈希链表,key与Node中key相同
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 如果存在节点，删除原位置节点并在队头新加节点
        Node node = map.get(key);
        // 删除节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // 在队头插入
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 缓存中已有，更新值，且get方法已将节点移至队头
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        // 缓存中没有
        // 容量满了，移除链表最后一个,更新map
        Node node = new Node(key, value);
        if (map.size() == cap) {
            map.remove(tail.pre.key);
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;
        }
        // 链表及哈希表中加入新节点
        map.put(key, node);
        addFirst(node);
    }

    public void addFirst(Node x) {
        x.next = head.next;
        x.pre = head;
        head.next.pre = x;
        head.next = x;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));     // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));      // 返回  3
        System.out.println(cache.get(4));      // 返回  4

    }
}

package LeetCode.first_0301;

import java.util.Hashtable;

/**
 * 146.LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 )
 */
//双向链表+Hashtable
public class Medium_146 {
    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public Medium_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        //判断key是否存在映射
        if (node == null) {
            //不存在映射
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            //添加映射
            cache.put(key, newNode);
            //链表中在head之后添加节点
            addNode(newNode);
            //链表长度加一
            size++;
            //如果超容，链表去掉最后一个节点，哈希表删除映射，size减小
            if (size > capacity) {
                DLinkedNode res = tail.prev;
                removeNode(res);
                cache.remove(res.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void addNode(DLinkedNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

    public void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);

    }

    public static void main(String[] args) {
        Medium_146 cache = new Medium_146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

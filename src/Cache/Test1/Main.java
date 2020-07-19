package Cache.Test1;

import java.util.HashMap;
import java.util.Scanner;
/*
6 3
1 1 1
1 2 2
1 3 2
2 1
1 4 4
2 2


输入
9 2
1 1 1
1 2 2
2 1
1 3 3
2 2
1 4 4
2 1
2 3
2 4
 */
public class Main {

    public static class LRUCache {
        // 使用哈希链表,key与Node中key相同
        private final HashMap<Integer, Node> map;
        private final Node head;
        private final Node tail;
        private final int cap;

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
            // 缓存中已有，更新值，且利用get方法将节点移至队头
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
    }

    // key,value链表节点
    public static class Node {
        public int key, value;
        Node next, pre;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int cap = input.nextInt();
        LRUCache cache = new LRUCache(cap);
        for (int i = 0; i < num; i++) {
            int opt = input.nextInt();
            if (opt == 1) {
                int key = input.nextInt();
                int value = input.nextInt();
                cache.put(key, value);
            } else if (opt == 2) {
                int key = input.nextInt();
                System.out.println(cache.get(key));
            }
        }
    }
}

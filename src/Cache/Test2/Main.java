package Cache.Test2;

import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static class LRUCache {
        HashMap<Integer, Node> map;
        Node head;
        Node tail;
        int capacity;
        public LRUCache(int capacity){
            map = new HashMap<>();
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
        }
        private void put(int key, int value){
            if (get(key) != -1) { // 缓存中已有，利用get放在最前，更新值即可
                map.get(key).value = value;
                return;
            }
            Node node = new Node(key, value);
            // 缓存中没有
            // 如果缓存已满
            if (map.size() == capacity){
                // 去掉队尾
                map.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
            }
            map.put(key, node);
            addToHead(node);
        }
        private int get(int key){
            if (!map.containsKey(key)){
                return -1;
            }
            // 缓存中已有
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            addToHead(node);
            return node.value;
        }
        private void addToHead(Node node){
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }

    public static class Node {
        int key,value;
        Node next,pre;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int capacity = input.nextInt();
        LRUCache cache = new LRUCache(capacity);
        for (int i = 0; i < num; i++){
            String s = input.next();
            if(s.equals("PUT")){
                int key = input.nextInt();
                int value = input.nextInt();
                cache.put(key,value);
            } else if(s.equals("GET")){
                int key = input.nextInt();
                System.out.println(cache.get(key));
            }
        }
    }
}

/*
示例1
输入
9 2
PUT 1 1
PUT 2 2
GET 1
PUT 3 3
GET 2
PUT 4 4
GET 1
GET 3
GET 4
输出
1
-1
-1
3
4
 */
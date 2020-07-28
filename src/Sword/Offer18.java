package Sword;
/*
剑指 Offer 18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

说明：

题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class Offer18 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        // 注意分情况，当删除的是头结点
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode p = head;
        ListNode pre = null;
        while (p.val != val) {
            pre = p;
            p = p.next;
        }
        // 当删除的是尾结点
        if (p.next == null) {
            pre.next = null;
        } else { // 删除的是中间结点
            p.val = p.next.val;
            p.next = p.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        int val = 5;
        ListNode res = new Offer18().deleteNode(node, val);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

package LinkedList;

import java.util.List;

/*
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]


提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
 */
public class Medium_24 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode l = head;
        ListNode r = head.next;
        head = head.next;
        while (l != null && r != null) {
            pre.next = r;
            l.next = r.next;
            pre = l;
            r.next = l;
            l = l.next;
            if (l != null)
                r = l.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode res = new Medium_24().swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

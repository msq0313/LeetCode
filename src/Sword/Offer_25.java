package Sword;
/*
剑指 Offer 25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000
 */
public class Offer_25 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                cur.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            cur = cur.next;
        }
        while (p1 != null) {
            cur.next = new ListNode(p1.val);
            p1 = p1.next;
            cur = cur.next;
        }
        while (p2 != null) {
            cur.next = new ListNode(p2.val);
            p2 = p2.next;
            cur = cur.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = new Offer_25().mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

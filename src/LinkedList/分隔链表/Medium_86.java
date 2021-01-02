package LinkedList.分隔链表;
/*
86. 分隔链表
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5
 */
public class Medium_86 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode p = head;
        ListNode l = left;
        ListNode r = right;
        while (p != null) {
            if (p.val < x) {
                l.next = new ListNode(p.val);
                l = l.next;
            } else {
                r.next = new ListNode(p.val);
                r = r.next;
            }
            p = p.next;
        }
        l.next = right.next;
        return left.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        ListNode res = new Medium_86().partition(head, x);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

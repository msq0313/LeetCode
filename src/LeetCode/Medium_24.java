package LeetCode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class Medium_24 {
    //链表节点定义
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //两两翻转，搞清head、prev、curr、next的关系
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode prev = result;
        while (head != null && head.next != null) {
            ListNode curr = head;
            ListNode next = head.next;

            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            head = curr.next;
        }
        return result.next;
    }

    //初始化链表
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        Medium_24 medium24 = new Medium_24();
        ListNode result = medium24.swapPairs(head);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);
    }
}

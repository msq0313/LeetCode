package LinkedList;
/*
328. 奇偶链表
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
示例 2:

输入: 2->1->3->5->6->4->7->NULL
输出: 2->3->6->7->1->5->4->NULL
说明:

应当保持奇数节点和偶数节点的相对顺序。
链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class Medium_328 {
    public static class ListNode {
        ListNode next;
        int val;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = head.next;
        ListNode left = head;
        ListNode right = head2;
        while (right.next != null) {
            left.next = right.next;
            left = left.next;
            if (right.next.next != null) {
                right.next = right.next.next;
                right = right.next;
            } else {
                right.next = null;
            }
            left.next = head2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        ListNode res = new Medium_328().oddEvenList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
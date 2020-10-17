package LinkedList;
/*
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
public class Medium_19 {
    private static class ListNode{
        ListNode next;
        int val;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        if (head.next == null){
            return null;
        }
        ListNode l = res;
        ListNode r = res;
        for(int i = 0; i < n; i++){
            r = r.next;
        }
        while(r.next != null){
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return res.next;
    }
}

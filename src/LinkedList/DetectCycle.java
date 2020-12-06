package LinkedList;

public class DetectCycle {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    // 找到成环节点
    ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 上面的代码类似 hasCycle 函数
        // 慢指针从头开始，与快指针继续同速前进
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

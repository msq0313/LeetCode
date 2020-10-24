package LinkedList;
/*
234. 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

输入: 1->2->3->2->1
输出: true
 */
public class Simple_234 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 递归栈双指针法
//    ListNode left;
//    public boolean isPalindrome(ListNode head) {
//        left = head;
//        return recurrence(head);
//    }
//
//    public boolean recurrence(ListNode right) {
//        if (right == null) {
//            return true;
//        }
//        boolean res = recurrence(right.next);
//        // 有一次不相等则不为回文链表
//        res = res && right.val == left.val;
//        left = left.next;
//        return res;
//    }

    // 快慢指针找中点，翻转后半部分链表法，空间复杂度O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);
        ListNode temp = right;

        // 对比两个链表
        while (right != null) {
            if (right.val != left.val) {
                res = false;
                break;
            }
            right = right.next;
            left = left.next;
        }

        // 修复原链表
        while (left.next.next != null) {
            left = left.next;
        }
        left.next = reverse(temp);
        ListNode h = head;
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }

        return res;
    }

    public ListNode reverse(ListNode head) {
        // 翻转链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(new Simple_234().isPalindrome(head));
    }
}

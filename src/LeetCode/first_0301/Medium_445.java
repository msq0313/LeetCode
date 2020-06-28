package LeetCode.first_0301;

import java.util.Stack;

/*
445.两数相加
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶：

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例：

输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 */
public class Medium_445 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int pre = 0;

        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            int x;
            if (stack1.isEmpty()) {
                x = stack2.pop();
            } else if (stack2.isEmpty()) {
                x = stack1.pop();
            } else {
                x = stack1.pop() + stack2.pop();
            }
            ListNode next = res.next;
            res.next = new ListNode((x + pre) % 10);
            res.next.next = next;
            pre = (x + pre) / 10;
        }
        if (pre > 0) {
            ListNode next = res.next;
            res.next = new ListNode(pre);
            res.next.next = next;
        }
        return res.next;
    }

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(7);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//        l1.next.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        Medium_445 medium_445 = new Medium_445();
        ListNode res = medium_445.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

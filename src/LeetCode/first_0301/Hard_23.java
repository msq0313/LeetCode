package LeetCode.first_0301;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
23. 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

 */
public class Hard_23 {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode() {

        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        boolean flag = false;
        for (ListNode listNode : lists) {
            if (listNode != null) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        for (ListNode listNode : lists) {
            ListNode cur = listNode;
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        System.out.println(list);
        ListNode res = new ListNode(list.get(0));
        ListNode cur = res;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode res = new Hard_23().mergeKLists(lists);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}

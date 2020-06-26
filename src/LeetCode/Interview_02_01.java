package LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
面试题 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
进阶：

如果不得使用临时缓冲区，该怎么解决？

 */
public class Interview_02_01 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //排序加去重
//    public ListNode removeDuplicateNodes(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode dummy = new ListNode(-1);
//        dummy.next = new ListNode(head.val);
//        head = head.next;
//        while (head != null) {
//            ListNode cur = dummy.next;
//            ListNode pre = dummy;
//            while (cur != null) {
//                if (head.val > cur.val) {
//                    cur = cur.next;
//                    pre = pre.next;
//                } else if (head.val < cur.val) {
//                    ListNode tmp = new ListNode(head.val);
//                    tmp.next = cur;
//                    pre.next = tmp;
//                    break;
//                } else {
//                    break;
//                }
//            }
//            if (cur == null) {
//                pre.next = new ListNode(head.val);
//            }
//            head = head.next;
//        }
//        return dummy.next;
//    }
    //哈希表
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        ListNode res = new Interview_02_01().removeDuplicateNodes(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

package LeetCode;
/*
147.对链表进行插入排序
插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 
示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */
public class Medium_147 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //链表插入排序
    public ListNode insertionSortList(ListNode head) {
        //新建链表镜像
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode tail = dummy;
        //当前链表指向头结点
        ListNode cur = head;
        //遍历头结点
        while (cur != null) {
            //当新链表尾部小于当前节点值时，尾部延长，将当前结点直接加入到尾部，当前结点指针后移
            if (tail.val < cur.val) {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
            } else {
                //当新链表尾部大于当前结点值时，为当前结点值寻找合适位置
                //tmp当前结点的下一个结点
                ListNode tmp = cur.next;
                //尾结点下一个结点指向tmp
                tail.next = tmp;
                //遍历新链表，直到找到比当前结点大的结点
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
                pre = dummy;
                cur = tmp;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        Medium_147 medium_147 = new Medium_147();
        ListNode res = medium_147.insertionSortList(node);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);
    }
}

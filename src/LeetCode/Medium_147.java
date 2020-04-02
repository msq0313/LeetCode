package LeetCode;
//插入排序，链表操作
//147对链表进行插入排序
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

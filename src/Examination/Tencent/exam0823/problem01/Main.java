package Examination.Tencent.exam0823.problem01;

import java.util.Arrays;

public class Main {
    /*
    给一个长度为n的链表，挖掉第k个元素，问挖掉元素后的序列。
     */
    private static class LinkNode{
        LinkNode next;
        int val;

        LinkNode(int x) {
            val = x;
        }
    }
    // 1 2 3 4 5
    public int[] helper(LinkNode root,int n, int k) {
        int[] res = new int[n - 1];
        for (int i = 0; i < n-1; i++) {
            if (i + 1 == k) {
                root = root.next;
            }
            res[i] = root.val;
            root = root.next;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkNode root = new LinkNode(1);
        root.next = new LinkNode(2);
        root.next.next = new LinkNode(3);
        root.next.next.next = new LinkNode(4);
        root.next.next.next.next = new LinkNode(5);
        int[] res = new Main().helper(root, 5, 3);
        System.out.println(Arrays.toString(res));
    }
}

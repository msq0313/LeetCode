package LeetCode.second_0628;

import java.util.ArrayList;
import java.util.Arrays;

/*
109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class Medium_109 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            }
    }

//    public TreeNode sortedListToBST(ListNode head) {
//        ArrayList<Integer> list = new ArrayList<>();
//        ListNode p = head;
//        while (p != null) {
//            list.add(p.val);
//            p = p.next;
//        }
//        int size = list.size();
//        int[] nums = new int[size];
//        for (int i = 0; i < list.size(); i++) {
//            nums[i] = list.get(i);
//        }
//
//        TreeNode res = cal(nums, 0, size - 1);
//        return res;
//    }
//
//    public TreeNode cal(int[] nums, int left, int right) {
//        if (left > right) {
//            return null;
//        }
//        int mid = left + (right - left) / 2;
//        TreeNode root = new TreeNode(nums[mid]);
//        System.out.println(root.val);
//        root.left = cal(nums, left, mid - 1);
//        root.right = cal(nums, mid + 1, right);
//        return root;
//    }

    // 中序遍历递归
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode res = new Medium_109().sortedListToBST(head);
        System.out.println(res.val + " " + res.left.val);
    }
}

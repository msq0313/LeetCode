package Examination.Sina.q1;
/*
二叉树翻转
1,2,3,4,5,6,7
4,5,2,3,6,7,1
 */


import java.util.Scanner;

public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] ss = s.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        TreeNode root = new TreeNode(nums[0]);
        generate(root, nums, 0);
        postOrder(root);
    }

    public static void generate(TreeNode p, int[] nums, int index) {
        int len = nums.length;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < len) {
            p.left = new TreeNode(nums[left]);
            generate(p.left, nums, left);
        }
        if (right < len) {
            p.right = new TreeNode(nums[right]);
            generate(p.right, nums, right);
        }
    }
    // 右子树先序遍历
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            postOrder(root.left);
            preOrder(root.right);
        }
    }
    // 左子树后序遍历
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            preOrder(root.right);
            System.out.println(root.val);
        }
    }
}
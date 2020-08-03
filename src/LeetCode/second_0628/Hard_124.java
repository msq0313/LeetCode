package LeetCode.second_0628;
/*
124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
 */
public class Hard_124 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxtrack(root);
        return res;
    }

    public int maxtrack(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        int left = maxtrack(root.left);
        int right = maxtrack(root.right);
        if (left > 0) {
            sum += left;
        }
        if (right > 0) {
            sum += right;
        }
        int temp = Math.max(left, right) + root.val;
        res = Math.max(res, sum);
        return Math.max(root.val, temp);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Hard_124().maxPathSum(root));
    }
}

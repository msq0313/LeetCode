package LeetCode.first_0301;
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
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42

 */
public class Simple_124 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return res;
    }

    public int max(TreeNode root) {
        /*
        后序遍历，为空时返回0
        遍历左子树得到结果为左子树路径和，如果小于0，记为0，更新最大值
        遍历右子树得到结果为右子树路径和，如果小于0，记为0，更新最大值
        当前路径最大值为：对比维护的最大值（子树路径和）和左右根三个结点（当前路径和）之和哪个大
        但因为是路径，所以返回只能返回左右结点较大的一方加上当前结点值
         */
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, max(root.left));
        int right = Math.max(0, max(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(0);

        System.out.println(new Simple_124().maxPathSum(root));
    }
}

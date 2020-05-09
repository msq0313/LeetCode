package LeetCode;
/*
98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

 */
public class Medium_98 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return recur(root, null,null);
    }

    public boolean recur(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (low != null && val <= low) return false;
        if (high != null && val >= high) return false;
        if (!recur(node.left, low, val)) return false;
        if (!recur(node.right, val, high)) return false;

        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(5);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(4);
        treeNode2.right.left = new TreeNode(3);
        treeNode2.right.right = new TreeNode(6);
        System.out.println(new Medium_98().isValidBST(treeNode1));
        System.out.println(new Medium_98().isValidBST(treeNode2));
    }
}

package BinaryTree;

import com.sun.javafx.scene.input.InputEventUtils;

/*
538. 把二叉搜索树转换为累加树
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

例如：

输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
 */
public class Simple_538 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        reMidOrder(root);
        return root;
    }

    int sum = 0;

    public void reMidOrder(TreeNode node) {
        if (node != null) {
            reMidOrder(node.right);
            node.val += sum;
            sum = node.val;
            reMidOrder(node.left);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(13);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode res = new Simple_538().convertBST(root);
        System.out.println(res.val);
        System.out.println(res.left.val);
        System.out.println(res.right.val);
    }
}

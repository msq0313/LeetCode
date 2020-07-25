package Sword;

import java.util.HashMap;
import java.util.Map;

/*
剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


限制：

0 <= 节点个数 <= 5000
 */
public class Offer07 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        int length = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, length - 1, 0, length - 1, map);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            return root;
        } else {
            int rootIndex = map.get(rootVal);
            int leftNodes = rootIndex - inStart;
            int rightNodes = inEnd - rootIndex;
            root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftNodes, inStart, rootIndex - 1, map);
            root.right = buildTree(preorder, inorder, preEnd - rightNodes + 1, preEnd, rootIndex + 1, inEnd, map);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode res = new Offer07().buildTree(preorder, inorder);
        System.out.println(res.val);
        System.out.println(res.right.val);
        System.out.println(res.right.right.val);
    }
}

package BinaryTree;

import java.util.TreeMap;

/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
public class Medium_106 {
    private static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if (poststart > postend) {
            return null;
        }
//        if (instart > inend) {
//            return null;
//        }
        int rootval = postorder[postend];
        TreeNode root = new TreeNode(rootval);
        int index = -1;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == rootval) {
                index = i;
                break;
            }
        }
        int d = index - instart;
        root.left = build(inorder,postorder,instart, index - 1,poststart,poststart + d - 1);
        root.right = build(inorder, postorder, index + 1, inend, poststart + d, postend - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode res = new Medium_106().buildTree(inorder, postorder);
        System.out.println(res.right.left.val);

    }
}

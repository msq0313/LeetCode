package BinaryTree;

import java.util.TreeMap;

/*
105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
public class Medium_105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend) {
            return null;
        }
        int rootval = preorder[prestart];
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootval) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootval);

        root.left = build(preorder, prestart + 1, prestart + index - instart, inorder, instart, index - 1);
        root.right = build(preorder, prestart + index - instart + 1, preend, inorder, index + 1, inend);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{
                3,9,20,15,7
        };
        int[] inorder = new int[]{
                9,3,15,20,7
        };
        TreeNode res = new Medium_105().buildTree(preorder, inorder);
        System.out.println(res.right.left.val);
    }
}

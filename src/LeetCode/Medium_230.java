package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 */
public class Medium_230 {
    public static class TreeNode {
        int val;
        TreeNode leftchild;
        TreeNode rightchild;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.leftchild = new TreeNode(1);
        tree.rightchild = new TreeNode(4);
        tree.leftchild.rightchild = new TreeNode(2);
        Medium_230 medium_230 = new Medium_230();
        System.out.println(medium_230.kthSmallest(tree, 2));
    }
    //递归中序遍历
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k - 1);
    }
    //非递归中序遍历
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.leftchild;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.rightchild;
        }
    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) return arr;
        inorder(root.leftchild,arr);
        arr.add(root.val);
        inorder(root.rightchild,arr);
        return arr;
    }
}

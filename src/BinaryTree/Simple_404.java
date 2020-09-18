package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Simple_404 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int res = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.left != null) {
//                queue.add(node.left);
//                if (node.left.left == null && node.left.right == null)
//                    res += node.left.val;
//            }
//            if (node.right != null) {
//                queue.add(node.right);
//            }
//        }
//        return res;
//    }
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }
    public int sumOfLeftLeaves(TreeNode root, boolean flag){
        if(root == null){
            return 0;
        }
        if(flag && root.left == null && root.right == null){
            return root.val;
        }
        int leftSum = sumOfLeftLeaves(root.left, true);
        int rightSum = sumOfLeftLeaves(root.right, false);
        return leftSum + rightSum;
    }

}
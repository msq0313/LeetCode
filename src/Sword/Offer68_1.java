package Sword;

public class Offer68_1 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode res = null;
        if (root.val >= Math.min(p.val, q.val) && (root.val <= Math.max(p.val, q.val))) {
            return root;
        } else if (root.val < Math.min(p.val, q.val)) {
            res = lowestCommonAncestor(root.right, p, q);
        } else if (root.val > Math.max(p.val, q.val)) {
            res = lowestCommonAncestor(root.left, p, q);
        }
        return res;
    }
}

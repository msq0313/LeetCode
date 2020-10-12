package BinaryTree;
/*
530. 二叉搜索树的最小绝对差
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。



示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class Simple_530 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res;
    int t;
    public int getMinimumDifference(TreeNode root) {
        res = Integer.MAX_VALUE;
        t = -1;
        midOrder(root);
        return res;
    }
    public void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            if (t == -1) {
                t = root.val;
            } else {
                res = Math.min(res, root.val - t);
                t = root.val;
            }
            midOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(new Simple_530().getMinimumDifference(root));
    }
}

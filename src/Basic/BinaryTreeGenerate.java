package Basic;

import java.util.LinkedList;

public class BinaryTreeGenerate {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            val = x;
        }
        TreeNode(){}
    }

    public TreeNode generate(TreeNode root, Integer[] nums, int index) {
        if (index == 0)
            root.val = nums[index];
        // 左子节点下标
        int l = index * 2 + 1;
        // 右子节点下标
        int r = index * 2 + 2;

        if (l >= nums.length)
            return root;
        root.left = new TreeNode(nums[l]);

        if (r >= nums.length)
            return root;
        root.right = new TreeNode(nums[r]);

        generate(root.left, nums, l);
        generate(root.right, nums, r);
        return root;
    }

    // 层序遍历s
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode cur;
        while (!list.isEmpty()) {
            cur = list.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                list.add(cur.left);
            }
            if (cur.right != null) {
                list.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {2, 1, 3, 5, 7, 8, 9};
        int index = 0;
        TreeNode root = new BinaryTreeGenerate().generate(new TreeNode(), nums, index);
        levelOrder(root);
    }
}

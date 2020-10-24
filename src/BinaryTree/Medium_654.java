package BinaryTree;
/*
654. 最大二叉树
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。


示例 ：

输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    /
     2  0
       \
        1


提示：

给定的数组的大小在 [1, 1000] 之间。
 */
public class Medium_654 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 找到最大值
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[index]);

        root.left = build(nums, start, index - 1);
        root.right = build(nums, index + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                3,2,1,6,0,5
        };
        TreeNode res = new Medium_654().constructMaximumBinaryTree(nums);
        System.out.println(res.right.left.val);
    }
}

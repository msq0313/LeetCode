package Basic;

import java.util.LinkedList;

public class TreeLevelOrder {

    //节点结构
    static class TreeNode
    {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value)
        {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{};
        TreeLevelOrder.TreeNode[] node = new TreeLevelOrder.TreeNode[10];
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeLevelOrder.TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10)
                node[i].left = node[i * 2 + 1];
            if (i * 2 + 2 < 10)
                node[i].right = node[i * 2 + 2];
        }
        levelOrder(node[0]);
    }

    //层次遍历
    public static void levelOrder(TreeNode node) {
        if (node == null)
            return;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(node);
        TreeNode cur;
        while (!list.isEmpty()) {
            cur = list.poll();
            System.out.println(cur.value);
            if (cur.left != null)
                list.add(cur.left);
            if (cur.right != null)
                list.add(cur.right);
        }
    }
}

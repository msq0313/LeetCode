package Basic;

import java.util.Stack;

public class TreeMidOrder {

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

    //以数组形式生成一棵完全二叉树
    public static void main(String[] args)
    {
        TreeNode[] node = new TreeNode[10];
        for(int i = 0; i < 10; i++)
        {
            node[i] = new TreeNode(i);
        }
        for(int i = 0; i < 10; i++)
        {
            if(i*2+1 < 10)
                node[i].left = node[i*2+1];
            if(i*2+2 < 10)
                node[i].right = node[i*2+2];
        }

        midOrderRe(node[0]);
        System.out.println();
        midOrder(node[0]);
    }

    //中序遍历递归实现
    public static void midOrderRe(TreeNode node)
    {
        if(node != null) {
            midOrderRe(node.left);
            System.out.println(node.value);
            midOrderRe(node.right);
        }
    }

    //中序遍历费递归实现
    public static void midOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }
}

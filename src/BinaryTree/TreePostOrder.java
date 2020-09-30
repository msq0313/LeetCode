package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreePostOrder {

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

        postOrderRe(node[0]);
        System.out.println("***");
        postOrder(node[0]);
    }

    //后序遍历递归实现
    public static void postOrderRe(TreeNode node)
    {
        if(node != null) {
            postOrderRe(node.left);
            postOrderRe(node.right);
            System.out.println(node.value);
        }
    }

    //后序遍历非递归实现
    public static void postOrder(TreeNode node) {
        int left = 1;
        int right = 2;
        //在辅助栈里表示左节点
        Stack<TreeNode> stack = new Stack<>();
        //在辅助栈里表示右节点
        Stack<Integer> stack2 = new Stack<>();
        //辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        //将节点压入栈1，并在栈2将节点标记为左节点
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                stack2.push(left);
                node = node.left;
            }

            //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
            while (!stack.empty() && stack2.peek() == right) {
                stack2.pop();
                System.out.println(stack.pop().value);
            }

            //如果是从左子节点返回父节点，则将标记改为右子节点
            if (!stack.empty() && stack2.peek() == left) {
                stack2.pop();
                stack2.push(right);
                node = stack.peek().right;
            }
        }
    }

    //后序遍历非递归实现
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                stack2.push(left);
                root = root.left;
            }
            while (!stack.empty() && stack2.peek() == right) {
                stack2.pop();
                res.add(stack.pop().value);
            }
            if (!stack.empty() && stack2.peek() == left) {
                stack2.pop();
                stack2.push(right);
                root = stack.peek().right;
            }
        }
        return res;
    }
}

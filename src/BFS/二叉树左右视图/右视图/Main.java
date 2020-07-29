package BFS.二叉树左右视图.右视图;

import java.util.*;

/*
链接：https://www.nowcoder.com/questionTerminal/d05399f810c0473eba364163831a749a
来源：牛客网

给定一棵二叉树，返回其右视图列表：即从二叉树右侧看过去，从上到下每层看到的最右边的值的数组。需要实现的函数头如下：
vector<int> rightView(TreeNode* root);
TreeNode定义如下：
class TreeNode {
        TreeNode *left, *right;
        int val;
};
Input：[5,6,9,null,null,7,8]  （层次遍历表示法）
Output：[5, 9, 8]

Input：[5,6,9,7,8,null,null,11]  （层次遍历表示法）
Output：[5, 9, 8]
 */
public class Main {
    // 结点定义
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
        TreeNode() {}
    }

    // 生成右视图节点值
    public ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    // 生成对应二叉树
    public TreeNode generate(TreeNode root, ArrayList<Integer> source, int index) {
        if (index == 0) {
            root.val = source.get(index);
        }
        int l = index * 2 + 1;
        int r = index * 2 + 2;

        if (l >= source.size()) {
            return root;
        }
        if (source.get(l) != null) {
            root.left = new TreeNode(source.get(l));
            generate(root.left, source, l);
        } else root.left = null;

        if (r >= source.size()) {
            return root;
        }
        if (source.get(l) != null) {
            root.right = new TreeNode(source.get(r));
            generate(root.right, source, r);
        } else root.right = null;

        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> source = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String[] vals = input.nextLine().split(",");
        for (String val : vals) {
            if (val.equals("null")) {
                source.add(null);
            } else
                source.add(Integer.valueOf(val));
        }
        Main main = new Main();
        TreeNode root = main.generate(new TreeNode(), source, 0);
        ArrayList<Integer> res = main.rightView(root);
        System.out.println(res);
    }
}

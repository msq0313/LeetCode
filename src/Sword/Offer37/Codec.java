package Sword.Offer37;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        String NULL = "null";
        String D = ",";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                sb.append(temp.val).append(D);
                queue.offer(temp.left);
                queue.offer(temp.right);
            } else {
                sb.append(NULL).append(D);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(data);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        String[] nodes = sb.toString().split(",");
        TreeNode res = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(res);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = queue.poll();
            String left = nodes[i++];
            if (!left.equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(left));
                queue.offer(cur.left);
            } else {
                cur.left = null;
            }
            String right = nodes[i];
            if (!right.equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(right));
                queue.offer(cur.right);
            } else {
                cur.right = null;
            }
        }

        return res;
    }
}

package LinkedList;

import java.util.Stack;

public class Test {
    private static class TreeNode{
        int val;
        TreeNode next;
        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.next = new TreeNode(2);
        TreeNode p = root.next;
        System.out.println(p == root); //false
        System.out.println(p.val == root.val);  //true
        p.next = new TreeNode(3);
        System.out.println(p.next == root.next.next); // true
        Stack stack = new Stack();
    }
}

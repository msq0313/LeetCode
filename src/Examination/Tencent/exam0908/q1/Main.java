package Examination.Tencent.exam0908.q1;
/*
6
6 5 4 3 2 1
5
6 5 4 2 1
 */
import java.util.Scanner;

public class Main {
    private static class LinkNode {
        int val;
        LinkNode next;

        LinkNode(int x) {
            val = x;
        }
    }

    public static void helper(LinkNode root1, LinkNode root2) {
        while (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                System.out.print(root1.val + " ");
                root1 = root1.next;
                root2 = root2.next;
            } else if (root1.val < root2.val) {
                root2 = root2.next;
            } else if (root1.val > root2.val) {
                root1 = root1.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len1 = input.nextInt();
        LinkNode root1 = new LinkNode(input.nextInt());
        LinkNode p1 = root1;
        for (int i = 1; i < len1; i++) {
            p1.next = new LinkNode(input.nextInt());
            p1 = p1.next;
        }
        int len2 = input.nextInt();
        LinkNode root2 = new LinkNode(input.nextInt());
        LinkNode p2 = root2;
        for (int i = 1; i < len2; i++) {
            p2.next = new LinkNode(input.nextInt());
            p2 = p2.next;
        }
        if (len1 >= len2) {
            helper(root1, root2);
        } else {
            helper(root2, root1);
        }
    }
}

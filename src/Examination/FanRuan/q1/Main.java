package Examination.FanRuan.q1;
/*
3 3 4 3
1:5 3:8 5:1
1:2 2:2 4:3 5:2
2:3 4:4 6:3

1:7 2:5 3:8 4:7 5:3 6:3
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Deque<int[]> list = new ArrayDeque<>();
        int n = input.nextInt();
        input.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s = input.nextLine().split(" ");
            for (int i1 = 0; i1 < s.length; i1++) {
                String[] nums = s[i1].split(":");
                queue.add(new int[]{Integer.parseInt(nums[0]), Integer.parseInt(nums[1])});
            }
        }
        list.addLast(queue.poll());
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            if (list.getLast()[0] == q[0]) {
                q[1] += list.getLast()[1];
                list.removeLast();
            }
            list.addLast(q);
        }
        for (int[] ints : list) {
            System.out.print(ints[0] + ":" + ints[1] + " ");
        }
    }
}
package Examination.Tencent.exam0908.q4;
/*
5
10 15 13 2 6
6  6  6  10 10
5
2 6 10 13 15
10 10 6 6 6

6
2 6 10 10 15 17
10 10 10 10 10 10

6
10 6 2 17 15 10

7
1 2 3 4 5 6 7
4 4 4 3 3 3 3

1 2 2 3 3 3 3
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        System.out.println(list);
        int a = list.get(n / 2);
        int b = list.get(n / 2 - 1);
        for (int num : nums) {
            if (num <= b) {
                System.out.print(a + " ");
            } else if (num >= a) {
                System.out.print(b + " ");
            }
        }
    }
}

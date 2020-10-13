package Examination.Baidu.q1;
/*
跳格子，可跳到下一格或者下一个相同数字，统计最少跳数
5
01212
3

5
21202
1

1
1
0

3
100
2

5
10000
1
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine();
        String s = input.nextLine();
        int[] dp = new int[N];
        dp[0] = 0;
        int t;
        for (int i = 1; i < N; i++) {
            for (t = 0; t < i; t++) {
                if (s.charAt(t) == s.charAt(i)) {
                    break;
                }
            }
            if (t < i) {
                dp[i] = Math.min(dp[i - 1], dp[t]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[N - 1]);
    }
}
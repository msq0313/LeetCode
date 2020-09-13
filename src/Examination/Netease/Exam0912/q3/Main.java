package Examination.Netease.Exam0912.q3;
/*
hello , ?
I am a boy
are you a girl ?

3
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int helper(List<String> l1, List<String> l2) {
        int len1 = l1.size();
        int len2 = l2.size();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (l1.get(i - 1).equals(l2.get(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ignore = input.nextLine();
        HashMap<String,Integer> map = new HashMap<>();
        String[] ig = ignore.split(" ");
        for (String s : ig) {
            map.put(s, 1);
        }

        String string1 = input.nextLine();
        String[] s1 = string1.split(" ");
        List<String> l1 = new ArrayList<>();
        for (String s : s1) {
            if (!map.containsKey(s)) {
                l1.add(s);
            }
        }

        String string2 = input.nextLine();
        String[] s2 = string2.split(" ");
        List<String> l2 = new ArrayList<>();
        for (String s : s2) {
            if (!map.containsKey(s)) {
                l2.add(s);
            }
        }

        int res = helper(l1, l2);
        System.out.println(res);
        System.out.println(l1);
        System.out.println(l2);
    }
}

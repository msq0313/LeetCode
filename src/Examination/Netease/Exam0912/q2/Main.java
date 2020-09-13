package Examination.Netease.Exam0912.q2;
/*

abbcbb

4 bb bbcbb bcb bb
 */

import java.util.Scanner;

public class Main {

    public static int helper(String s) {
        int res = 0;
        if (s.length() == 0 || s.length() == 1) {
            return res;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                res++;
                int left = i - 1;
                int right = i + 2;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int res = helper(s);
        System.out.println(res);
    }
}
package LeetCode.second_0628;

import java.util.ArrayDeque;
import java.util.Deque;

/*
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */
public class Hard_32 {
//    public int longestValidParentheses(String s) {
//        //保持栈底元素为最后一个右括号
//        int res = 0;
//        Deque<Integer> dq = new ArrayDeque<>();
//        dq.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            //左括号就入栈
//            if (s.charAt(i) == '(') {
//                dq.push(i);
//            } else if (s.charAt(i) == ')') {
//                //右括号先弹栈，空就压入右括号，不空就返回当前最大子串长度
//                dq.pop();
//                if (dq.isEmpty()) {
//                    dq.push(i);
//                } else {
//                    //返回最大的i-dq.peek()
//                    res = Math.max(res, i - dq.peek());
//                }
//            }
//        }
//        return res;
//    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(new Hard_32().longestValidParentheses(s));
    }
}

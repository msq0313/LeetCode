package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class Medium_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        //特殊值判断
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String curstring, int left, int right, List<String> res) {
        //括号剩余数都为0，结算
        if (left == 0 && right == 0) {
            res.add(curstring);
            return;
        }
        //剪枝
        if (right < left) {
            return;
        }
        if (left > 0) {
            dfs(curstring + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(curstring + ")", left, right - 1, res);
        }
    }

    public List<String> dp(int n) {
        //特殊值判定
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>(n);
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - j - 1);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        //dfs
        List<String> res = new Medium_22().generateParenthesis(3);
        for (String str : res) {
            System.out.println(str);
        }
        System.out.println("===================");
        //dp
        List<String> res2 = new Medium_22().dp(3);
        for (String str : res2) {
            System.out.println(str);
        }
    }
}

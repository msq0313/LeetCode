package LeetCode;

import java.util.Arrays;

/**
 * 1111. 有效括号的嵌套深度
 *
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 *
 * 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
 * A 或 B 中的元素在原字符串中可以不连续。
 * A.length + B.length = seq.length
 * 深度最小：max(depth(A), depth(B)) 的可能取值最小。 
 * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
 *
 * answer[i] = 0，seq[i] 分给 A 。
 * answer[i] = 1，seq[i] 分给 B 。
 * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
 *
 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 *
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * 解释：本示例答案不唯一。
 * 按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1，它们的深度最小。
 * 像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
 *
 */
public class Medium_1111 {
    //当遍历seq时，当前深度一定小于最大深度，而A的当前深度一定小于等于当前深度的一半，所以遍历一遍即可
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] res = new int[len];
        int depth = 0;
        int a_depth = 0;
        for (int i = 0; i < len; i++) {
            //是左括号时，当前深度+1，如果A深度小于等于当前深度一半，归为A，否则归为B
            if (seq.charAt(i) == '(') {
                depth++;
                if (a_depth <= (depth - 1) / 2) {
                    a_depth++;
                    res[i] = 0;
                } else res[i] = 1;
            } else {
                //是右括号时，当前深度-1，如果A深度大于零，证明还有左括号没匹配完，归为A，否则归为B
                depth--;
                if (a_depth > 0) {
                    res[i] = 0;
                    a_depth--;
                } else {
                    res[i] = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium_1111 medium_1111 = new Medium_1111();
        System.out.println(Arrays.toString(medium_1111.maxDepthAfterSplit("(()())")));;
    }
}

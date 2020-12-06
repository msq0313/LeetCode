package Array.翻转矩阵后的得分;

import java.util.Arrays;

/*
861. 翻转矩阵后的得分
有一个二维矩阵 A 其中每个元素的值为 0 或 1 。

移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

返回尽可能高的分数。

示例：

输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

提示：

1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j] 是 0 或 1

 */
public class Solution {
    // 贪心法，不用修改原数组，直接计算贡献即可
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }

    public int matrixScore2(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int i1 = 0; i1 < A[0].length; i1++) {
                    if (A[i][i1] == 0) {
                        A[i][i1] = 1;
                    } else {
                        A[i][i1] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int i1 = 0; i1 < A.length; i1++) {
                if (A[i1][i] == 0) {
                    count0++;
                } else {
                    count1++;
                }
            }
            if (count0 > count1) {
                for (int i1 = 0; i1 < A.length; i1++) {
                    if (A[i1][i] == 0) {
                        A[i1][i] = 1;
                    } else {
                        A[i1][i] = 0;
                    }
                }
            }
        }
        int p = 1;
        int sum = 0;
        for (int i = A[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < A.length; j++) {
                sum += A[j][i];
            }
            res += p * sum;
            p *= 2;
            sum = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };
        System.out.println(new Solution().matrixScore(A));
    }
}

package LeetCode.second_0628;

import java.util.HashMap;
import java.util.Map;

/*
887. 鸡蛋掉落
你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。

每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。

每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。

你的目标是确切地知道 F 的值是多少。

无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 
示例 1：

输入：K = 1, N = 2
输出：2
解释：
鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
如果它没碎，那么我们肯定知道 F = 2 。
因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
示例 2：

输入：K = 2, N = 6
输出：3
示例 3：

输入：K = 3, N = 14
输出：4
 

提示：

1 <= K <= 100
1 <= N <= 10000

 */
public class Hard_887 {
//    Map<Integer[], Integer> memo = new HashMap<>();
//    public int superEggDrop(int K, int N) {
//        if (K == 0) {
//            return 0;
//        }
//        return dp(K, N);
//    }
//    //求有K个鸡蛋时，搜索楼层数为N时最坏情况下最少需要扔几次
//    public int dp(int K, int N) {
//        //base case
//        if (K == 1) {
//            return N;
//        }
//        if (N == 0) {
//            return 0;
//        }
//        if (memo.containsKey(new Integer[]{K, N})) {
//            return memo.get((new Integer[]{K, N}));
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <= N; i++) {
//            res = Math.min(res, Math.max(
//                    dp(K - 1, i - 1), //碎
//                    dp(K, N - i) //没碎
//            ) + 1); //在第 i 楼扔了一次
//            memo.put(new Integer[]{K, N}, res);
//        }
//        return res;
//    }

    public int superEggDrop(int K, int N) {
        //设扔鸡蛋次数为m，探索随着m增加，可覆盖的楼层有多少，当大于等于N时，返回m
        // m 最多不会超过 N 次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
        // base case:
        // dp[0][..] = 0
        // dp[..][0] = 0
        // Java 默认初始化数组都为 0
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int K = 3;
        int N = 25;

        System.out.println(new Hard_887().superEggDrop(K, N));
    }
}

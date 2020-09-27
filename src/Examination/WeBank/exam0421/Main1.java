package Examination.WeBank.exam0421;

import java.util.Scanner;

public class Main1 {

    /**
     * 微众 第 1 题，最小花费问题
     * n个朋友m个礼物，要求均分礼物，(1)可以花a元送红包打发走一位朋友；(2)花b元再买一件礼物，两种操作可以混着用，要求输出打发所有朋友的最小花费
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n个小朋友
        int m = sc.nextInt(); // m份礼物
        int a = sc.nextInt(); // 每个红包的花费
        int b = sc.nextInt(); // 每个礼物的价值
        sc.close();
        System.out.println(minCost(n, m, a, b));
    }
    private static int minCost(int n, int m, int a, int b) {
        if (n > m) { // 当人数大于礼物数时
            // 此时对于 (人数和礼物数) 的差值，要么发红包，要么买新礼物，且 红包数+新礼物数 = n - m
            // 此时当然是选 单个红包和礼物中较便宜的那个。
            return (n - m) * Math.min(a, b);

        } else if (m % n == 0){ // 当可以完全均分时，不需要额外花钱
            return 0;

        } else { // 其他情况为：当人数小于礼物数时，且不能完全均分时
            // 列出线性规划方程
            // n：总客人数， m：总礼物数
            // x：离开多少人，y：买多少礼物，k的目的是：让礼物能完全均分，k必须是自然数
            // 方程1：k * (n - x) = m + y
            // 方程2：minCost = x * a + y * b，求能使minCost最小的 x 和 y。
            int res = Integer.MAX_VALUE;

            // redPacketNum代表发几个红包，最多只需要发 n-1 个红包
            for (int redPacketNum = 0; redPacketNum < n; redPacketNum++) {
                // 求出当发 redPacketNum 个红包时，需要买的礼物数 buyGiftNum
                if (m % (n - redPacketNum) == 0) {
                    res = Math.min(res , redPacketNum * a);
                } else {
                    int buyGiftNum = (m / (n - redPacketNum) + 1) * (n - redPacketNum) - m;
                    res = Math.min(res , redPacketNum * a + buyGiftNum * b);
                }
            }
            return res;
        }
    }
}

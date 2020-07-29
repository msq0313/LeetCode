package Examination.Glodon.exam0729;

import java.util.Scanner;

/*
堆积木
时间限制： 3000MS
内存限制： 589824KB
题目描述：
同同在玩积木，每个积木上都有一个独一无二的二进制数字。同同的积木有特殊的规则，只有满足规则的积木才能被垒到一起。

对于一个积木，如果积木上写的数字是a，则对于所有的写着数字b的积木，只要满足a∩b=b,其中∩代表二进制与运算，
则积木b可以放到积木a的上面。每一堆积木最多仅有一个积木可以充当底座，被放在底座上的所有积木都必须满足上述关系。
（只要底座和积木满足关系即可以放在一堆，不需要考虑如何码放）

同同有一只笔，只能使用一次，效果是把某一个积木上数字的某一位从0改成1或者从1改成0。请问同同最少能让积木分在几堆里。

二进制与运算的定义：对于两个数a,b，写出它们的二进制形式a0a1am...和b0b1bm，设c 为与运算的结果，
则有当a0和b0同时为1 时c0为1，其他位同理。

输入描述
第一行两个数n,m(1≤m≤20,1≤n≤min(105,2m))，分别代表积木的数量和积木上数字对应二进制位最多有几位

第二行n个整数a1,a2,...,an(0≤ai≤2m)，代表每个积木上写的二进制数字的十进制表示形式。

输入保证每个积木上的数字不重复。

输出描述
一行一个整数代表最少的堆数。

样例输入
5 4
10 2 4 8 9
样例输出
2

提示
样例解释
五个数的二进制形式分别是
1010
0010
0100
1000
1001
 */
public class Main3 {
    // 并查集
    public static class UnionFind {
        private final int[] parent;
        private int[] size;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            } else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
            count--;
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int t = nums[i] & nums[j];
                if (t == nums[i] || t == nums[j]) {
                    uf.union(i, j);
                }
            }
        }
        System.out.println(uf.count);
    }
}

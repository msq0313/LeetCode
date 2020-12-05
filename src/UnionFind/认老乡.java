package UnionFind;

import java.util.Scanner;

/*
动脑子认老乡
大学的同学来自全国各地，对于远离家乡步入陌生大学校园的大一新生来说，碰到老乡是多么激动的一件事，
于是大家都热衷于问身边的同学是否与自己同乡，来自新疆的小赛尤其热衷。但是大家都不告诉小赛他们来自哪里，
只是说与谁是不是同乡，从所给的信息中，你能告诉小赛有多少人确定是她的同乡吗？

输入
包含多组测试用例。
对于每组测试用例：
第一行包括2个整数，N（1 <= N <= 1000），M(0 <= M <= N*(N-1)/2)，代表现有N个人（用1~N编号）和M组关系；

在接下来的M行里，每行包括3个整数，a，b, c，如果c为1，则代表a跟b是同乡；如果c为0，则代表a跟b不是同乡；

已知1表示小赛本人。

样例输入
3 1
2 3 1
5 4
1 2 1
3 4 0
2 5 1
3 2 1

输出
对于每组测试实例，输出一个整数，代表确定是小赛同乡的人数。
 */
public class 认老乡 {
    public static class UnionFind{
        int[] parent;
        int[] size;
        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (size[rootA] > size[rootB]) {
                    parent[rootB] = rootA;
                    size[rootA] += size[rootB];
                } else {
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                }
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        private boolean isConnected(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int N = input.nextInt();
            int M = input.nextInt();
            UnionFind uf = new UnionFind(N + 1);
            for (int i = 0; i < M; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                int flag = input.nextInt();
                if (flag == 1) {
                    uf.union(a, b);
                }
            }
            int count = 0;
            for (int i = 2; i <= N; i++) {
                if (uf.isConnected(1, i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

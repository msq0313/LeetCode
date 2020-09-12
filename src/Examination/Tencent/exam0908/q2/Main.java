package Examination.Tencent.exam0908.q2;
/*
50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 8 2

9 3
2 1 2
2 0 1
4 6 7 8 2
 */
import java.util.Scanner;

public class Main {
    public static class UF{
        int count;
        int[] parent;
        int[] size;

        UF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
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
        }

        public boolean isConnected(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int all = input.nextInt();
        int n = input.nextInt();
        UF uf = new UF(all);
        int a;
        int b;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int len = input.nextInt();
            a = input.nextInt();
            for (int j = 1; j < len; j++) {
                b = input.nextInt();
                uf.union(a, b);
            }
        }
        for (int i = 0; i < all; i++) {
            if (uf.isConnected(0, i)) {
                res++;
            }
        }
        System.out.println(res);
    }
}

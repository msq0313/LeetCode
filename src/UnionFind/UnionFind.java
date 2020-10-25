package UnionFind;

public class UnionFind {
    // 记录连通分量个数
    private int count;
    private int[] parent;
    private int[] size;
    // 初始化
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 找父节点并压缩树高
    private int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    // 将两个结点连接
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        //小树挂在大树下
        if (size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        count--;
    }

    // 判断两个结点是否连接，即判断两个结点的父结点是否相等
    public boolean isConnected(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        System.out.println(uf.count);
        System.out.println(uf.isConnected(1, 2));
        uf.union(1, 2);
        System.out.println(uf.isConnected(1, 2));
        System.out.println(uf.count);
    }
}

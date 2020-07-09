package UnionFind;

public class UF {
    // 记录连通分量个数
    int count;
    // 父节点
    int[] parent;
    // 树的重量
    int[] size;
    // 初始化
    public UF(int n) {
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
        //小树挂在大树下
        if (size[a] > size[b]) {
            parent[b] = a;
            size[a] += size[b];
        } else {
            parent[a] = b;
            size[b] += size[a];
        }
        count--;
    }

    // 判断两个结点是否连接
    public boolean isConnected(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }

    public static void main(String[] args) {
        UF uf = new UF(5);
        System.out.println(uf.count);
        System.out.println(uf.isConnected(1, 2));
        uf.union(1, 2);
        System.out.println(uf.isConnected(1, 2));
        System.out.println(uf.count);
    }
}

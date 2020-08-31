package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
841. 钥匙和房间
有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。

在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。

最初，除 0 号房间外的其余所有房间都被锁住。

你可以自由地在房间之间来回走动。

如果能进入每个房间返回 true，否则返回 false。

示例 1：

输入: [[1],[2],[3],[]]
输出: true
解释:
我们从 0 号房间开始，拿到钥匙 1。
之后我们去 1 号房间，拿到钥匙 2。
然后我们去 2 号房间，拿到钥匙 3。
最后我们去了 3 号房间。
由于我们能够进入每个房间，我们返回 true。
示例 2：

输入：[[1,3],[3,0,1],[2],[0]]
输出：false
解释：我们不能进入 2 号房间。
提示：

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
所有房间中的钥匙数量总计不超过 3000。
 */
public class Medium_841 {
    // BFS
//    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        if (rooms == null || rooms.size() == 0) {
//            return false;
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        int size = rooms.size();
//        boolean[] isVisited = new boolean[size];
//        int count = 1;
//        for (Integer integer : rooms.get(0)) {
//            if (integer != 0)
//                queue.offer(integer);
//        }
//        isVisited[0] = true;
//        while (!queue.isEmpty()) {
//            int temp = queue.poll();
//            if (!isVisited[temp]) {
//                isVisited[temp] = true;
//                count++;
//                for (Integer integer : rooms.get(temp)) {
//                        queue.offer(integer);
//                }
//            }
//        }
//        return count == size;
//    }

    // DFS
    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return false;
        }
        int size = rooms.size();
        boolean[] isVisited = new boolean[size];
        dfs(rooms,0, isVisited);
        return count == size;
    }

    public void dfs(List<List<Integer>> rooms, int x, boolean[] isVisited) {
        isVisited[x] = true;
        count++;
        if (count == rooms.size()) {
            return;
        }
        List<Integer> list = rooms.get(x);
        for (Integer integer : list) {
            if (!isVisited[integer]) {
                dfs(rooms, integer, isVisited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new LinkedList<>();
        list3.add(2);
        List<Integer> list4 = new LinkedList<>();
        list4.add(0);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        System.out.println(new Medium_841().canVisitAllRooms(rooms));
    }
}

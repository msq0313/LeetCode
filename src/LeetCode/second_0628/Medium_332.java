package LeetCode.second_0628;

import java.util.*;

/*
332. 重新安排行程
给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。

说明:

如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，
排序更靠前   所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
示例 1:

输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
示例 2:

输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class Medium_332 {
//    List<String> res = new LinkedList<>();
//    public List<String> findItinerary(List<List<String>> tickets) {
//        int len = tickets.size();
//        boolean[] isUsed = new boolean[len];
//        res.add("JFK");
//        findnext(tickets, isUsed, len);
//        return res;
//    }
//
//    public void findnext(List<List<String>> tickets, boolean[] isUsed, int len) {
//        if (res.size() == len + 1) {
//            return;
//        }
//        String last = res.get(res.size() - 1);
//        String next = "ZZZ";
//        int index = 0;
//        for (int i = 0; i < len; i++) {
//            String from = tickets.get(i).get(0);
//            if (!isUsed[i] && last.equals(from)) {
//                String to = tickets.get(i).get(1);
//                if (to.compareTo(next) < 0) {
//                    next = to;
//                    index = i;
//                }
//            }
//        }
//        res.add(next);
//        isUsed[index] = true;
//        findnext(tickets, isUsed, len);
//    }

    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new LinkedList<>();
        List<String> route1 = new LinkedList<>();
        route1.add("MUC");
        route1.add("LHR");
        List<String> route2 = new LinkedList<>();
        route2.add("JFK");
        route2.add("MUC");
        List<String> route3 = new LinkedList<>();
        route3.add("SFO");
        route3.add("SJC");
        List<String> route4 = new LinkedList<>();
        route4.add("LHR");
        route4.add("SFO");
        tickets.add(route1);
        tickets.add(route2);
        tickets.add(route3);
        tickets.add(route4);
        System.out.println(new Medium_332().findItinerary(tickets));
    }
}

package Examination.Tencent.exam0908.q3;

/*
 * N 个字符串， 求出现前 K多和前 K少的字符串，保证 K 合法
 * 输出， 前 K行是前 K 多， 按照出现次数从大到小，若出现次数相同，按字典序从小到大
 * 输出， 后 K行是前 K 少， 按照出现次数从少到多，若出现次数相同，按字典序从小到大
 */

/*
输出前k多和前k少的字符串。
5 2
abc
bcd
bcd
cde
cde

bcd 2
cde 2
abc 1
bcd 2
 */
import java.util.*;

public class Main {

    private static class Node{
        String s;
        int count;

        Node(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        input.nextLine();
        for (int i = 0; i < n; i++) {
            String s = input.nextLine();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        List<Node> list = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            list.add(new Node(string, map.get(string)));
        }
        /*
             * int compare(Student o1, Student o2) 返回一个int， 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等， 返回正数表示：o1大于o2。
         */
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.count != o2.count) {
                    return o2.count - o1.count;
                } else {
                    return o1.s.compareTo(o2.s);
                }
            }
        });
        for (int i = 0; i < k; i++) {
            Node node = list.get(i);
            System.out.println(node.s + " " + node.count);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.count != o2.count) {
                    return o1.count - o2.count;
                } else {
                    return o1.s.compareTo(o2.s);
                }
            }
        });
        for (int i = 0; i < k; i++) {
            Node node = list.get(i);
            System.out.println(node.s + " " + node.count);
        }
    }
}

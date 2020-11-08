package Basic;

import org.junit.Test;

import java.util.*;

public class Notebook {

    /**
     * 数组填充
     */
    @Test
    public void test1() {
        int[] nums = new int[3];
        Arrays.fill(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
    /*

    /**
     * 自定义比较器，o1 - o2升序
     */
    @Test
    public void test2() {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.sort(cmp);
        Collections.sort(list, cmp);
        System.out.println(list);
    }

    /*



    优先队列排序条件案例
    PriorityQueue<Pair> heap = new PriorityQueue<>((Pair p1, Pair p2) ->
                        (p1.num.equals(p2.num)) ? p2.money.compareTo(p1.money) : p2.num.compareTo(p1.num));
    a.compareTo(b) a = b 返回0  a < b 返回负数 a > b返回正数
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    */
    @Test
    public void test() {
        int[] num1 = {2, 3};
        int[] num2 = {1, 2};
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }
    /*

    */

    /**
     * 二维数组按第一位排序
     */
    @Test
    public void test3() {
        int[][] nums = {{3, 2}, {2, 3}, {1, 1}};
        Arrays.sort(nums, Comparator.comparingInt(p -> p[1]));
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

    /**
     * 自定义集合排序
     */
    @Test
    public void test5() {
        List<int[]> list = new ArrayList<>();
        int[] a = new int[]{3, 3};
        int[] b = new int[]{2, 2};
        int[] d = new int[]{1, 3};
        int[] c = new int[]{1, 2};
        list.add(a);
        list.add(b);
        list.add(d);
        list.add(c);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else
                    return o1[1] - o2[1];
            }
        });
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 字符串截取（左闭右开）
     * s.substring(int beginIndex, int endIndex)
     */
    @Test
    public void test6() {
        String s = "abcdefg";
        System.out.println(s.substring(3, 7));

    }

    /**
     * 程序运行时间（纳秒）
     */
    @Test
    public void test7() {
        long startTime = System.nanoTime();   //获取开始时间
        System.out.println("程序运行");
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+ (endTime-startTime) +"ns");
    }

    /**
     * 字符串内字符替换
     */
    @Test
    public void test8() {
        String s = " 123 456 789";
        System.out.println(s.replaceAll("\\s", "%20"));

    }

}

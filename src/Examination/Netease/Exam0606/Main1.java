package Examination.Netease.Exam0606;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
1. MxM的网格，某些网格上有加成（一个正整数），其余网格值为零，你在X,Y的位置，手拿一把长为L的刀，
可以朝任意方向砍一刀，如果砍到加成，则砍刀变长对应数值。你可以坎任意刀，请问最终刀的长度是多少？

2
10 3
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 2 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 0 2 0 0 0
0 0 0 0 0 0 0 0 0 2
0 0 0 1 0 0 0 0 0 1
0 0 0 1 0 0 2 0 2 0
8 8
10 2
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 2 0 0 1 0 0 0 0
0 0 0 1 2 0 2 0 0 0
0 0 0 0 2 1 2 0 2 0
0 0 2 0 0 0 0 0 2 0
0 0 0 0 0 0 0 2 0 0
0 0 0 1 0 0 0 0 0 0
2 5
 */
public class Main1 {

    public static int distance(int x , int y, int i, int j) {
        return (int)Math.ceil(Math.sqrt(Math.pow(x - i, 2) + Math.pow(y - j, 2)));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int T2 = T;
        int[] res = new int[T];
        while (T > 0) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int M = input.nextInt();
            int L = input.nextInt();
            res[T - 1] = L;
            int[][] map = new int[M][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = input.nextInt();
                }
            }

            int x = input.nextInt();
            int y = input.nextInt();

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        int distance = distance(x, y, i, j);
//                        if (T == 1)
//                            System.out.println(distance);
                        hashMap.put(distance, hashMap.getOrDefault(distance, 0) + map[i][j]);
                    }
                }
            }

            Set<Integer> set = hashMap.keySet();
            Object[] arr = set.toArray();
            Arrays.sort(arr);
            for (Object key : arr) {
                if (res[T - 1] >= (Integer)key)
                    res[T - 1] += hashMap.get(key);
//                System.out.println(hashMap.get(key));
            }
            T--;
        }
        for (int i = T2 - 1; i >= 0; i--) {
            System.out.println(res[i]);
        }
    }
}

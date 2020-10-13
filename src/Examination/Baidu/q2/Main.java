package Examination.Baidu.q2;
/*
参赛选手数量n、比赛场数m、牛牛的编号p
接下来几场比赛，第一个数赢第二个数
4 3 4
1 2
2 3
4 3

1 2 3

5 4 4
4 1
4 2
4 3
5 4
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 参赛选手数量
        int n = input.nextInt();
        int m = input.nextInt();
        // 牛牛号
        int p = input.nextInt();
        int[][] nums = new int[m][2];
        for (int i = 0; i < m; i++) {
            nums[i][0] = input.nextInt();
            nums[i][1] = input.nextInt();
        }

        Set<Integer> big = new HashSet<>();
        Set<Integer> small = new HashSet<>();

        findSmall(nums, p, m, small);
        findBig(nums, p, m, big);
        System.out.println(Arrays.toString(small.toArray()));
        System.out.println(Arrays.toString(big.toArray()));

        int min = small.size();
        int max = big.size();
        for (int i = max + 1; i <= n - min; i++) {
            System.out.print(i + " ");
        }

    }
    public static void findSmall(int[][] nums, int p, int m, Set<Integer> small) {
        for (int i = 0; i < m; i++) {
            if (nums[i][0] == p && !small.contains(nums[i][1])) {
                small.add(nums[i][1]);
                findSmall(nums, nums[i][1], m, small);
            }
        }
    }

    public static void findBig(int[][] nums, int p, int m, Set<Integer> big) {
        for (int i = 0; i < m; i++) {
            if (nums[i][1] == p && !big.contains(nums[i][0])) {
                big.add(nums[i][0]);
                findBig(nums, nums[i][0], m, big);
            }
        }
    }

}
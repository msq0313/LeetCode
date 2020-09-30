package Examination.WeBank.exam0927.q1;
/*
题目描述：
给定一个长度为n的数组a，我们定义一个数x的近似值是在数组a中与x的差值的绝对值最小，如果两个数的绝对值相等，就取较小的那个。比如说对于[2, 5, 7]，4的近似值就是5，而6的近似值应该取5，因为5更小。

现在有q个询问，对每个询问回答近似值。

输入描述
第一行两个整数n, q分别表示数组的长度和查询的次数。(1≤n，q≤1e5)

第二行n个数分别表示a1, a2, a3, … an。(0≤ai≤1e8)

接下来q行每行一个数x表示需要查询的数。(0≤x≤1e8)

输出描述
对于每个询问，输出一个近似值。

5 5
1 2 3 4 5
3
0
7
2
5

5 5
2 4 6 7 8
3
0
7
2
5

2
2
7
2
4
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int n = input.nextInt();
        int[] nums = new int[len];
        int x;
        for (int i = 0; i < len; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            x = input.nextInt();
//            System.out.println(new Main().find(nums, x));
//            System.out.println(new Main().find(nums,0, len-1, x));
        }
    }

//    public int find(int[] nums, int x) {
//        int res = nums[nums.length - 1];
//        for (int i = 0; i < nums.length; i++) {
//            if (x == nums[i]) {
//                res = x;
//                break;
//            } else if (x < nums[i]) {
//                if (i == 0) {
//                    res = nums[0];
//                    break;
//                } else {
//                    res = nums[i - 1];
//                    break;
//                }
//            }
//        }
//        return res;
//    }

//    public int find(int[] nums, int left, int right, int x) {
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == x) {
//                return x;
//            } else if (nums[mid]) {
//            }
//        }
//    }
}
package Examination.WeBank.exam0927.q3;
/*
题目描述：
给你一个长度为n的序列A，你需要算出有多少个三元组(Ai,Aj,Ak)满足i<j<k且Ai≤Aj≤Ak。

输入描述
第一行一个整数n，表示序列A的长度。

接下来一行n个整数，第i个数表示Ai的值。

输出描述
一个整数x，表示满足要求的三元组数量。

6
2 3 5 4 3 3

6
 */

/*
6
2 3 5 4 3 3
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(new Main().solution(nums));
    }

    private int solution(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] <= nums[j] && nums[j] <= nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
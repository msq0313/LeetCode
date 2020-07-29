package Examination.Glodon.exam0729;

import java.util.Arrays;
import java.util.Scanner;

/*
各不相同
时间限制： 3000MS
内存限制： 589824KB
题目描述：
我们希望一个序列中的元素是各不相同的，但是理想和现实往往是有差距的。现在给出一个序列A，其中难免有些相同的元素，现在提供了一种变化方式，使得经过若干次操作后一定可以得到一个元素各不相同的序列。

这个操作是这样的，令x为序列中最小的有重复的数字，你需要删除序列左数第一个x，并把第二个x替换为2*x。

请你输出最终的序列。

例如原序列是[2,2,1,1,1],一次变换后变为[2,2,2,1]，两次变换后变为[4,2,1]，变换结束
5
2 2 1 1 1
输入描述
输入第一行包含一个正整数n，表示序列的长度为n。(1<=n<=50000)

第二行有n个整数，初始序列中的元素。(1<=a_i<=10^8)

输出描述
输出包含若干个整数，即最终变换之后的结果。

样例输入
5
2 2 1 1 1
样例输出
4 2 1
样例输入
5
5 5 5 5 4
样例输出
20 4
 */
public class Main2 {
    // 找到最小的有重复数字的值
    public static int findMin(int[] nums) {
        int res = 0;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                continue;
            }
            if (temp[i] == temp[i-1]) {
                res = temp[i];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        while (true) {
            int i = 0;
            // min为最小有重复数的值
            int min = findMin(nums);
            if (min == 0) {
                break;
            }
            while (nums[i] != min) {
                i++;
            }
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    nums[i] = 0;
                    nums[j] *= 2;
                    break;
                }
            }
        }
        // 非0数打印
        for (int num : nums) {
            if (num != 0) {
                System.out.print(num + " ");
            }
        }
    }
}

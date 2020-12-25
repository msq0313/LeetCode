package Examination.Baidu.Interview.q3;
/*
数字n，多少种连续的数之和等于n
9
2
6
1
15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
不算自身
1 2 3 4 5 6 7 8 9
4 5
2 3 4
1 8

 */

public class Main {
    public int countN(int n) {
        int count = 0;
        int left = 1;
        int right = 1;
        int window = 0;
        while (right < n) {
            if (window == n) {
                count++;
            }
            window += right++;
            while (window > n) {
                window -= left++;
            }
        }
        return count;
    }

    public int count(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int count = 0;
        int left = 0;
        int right = 0;
        int window = 0;
        while (right < n) {
            if (window == n) {
                count++;
            }
            window += nums[right++];
            while (window > n) {
                window -= nums[left++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Main().countN(6));
        System.out.println(new Main().countN(9));
        System.out.println(new Main().countN(15));

//        System.out.println(new Main().count(6));
//        System.out.println(new Main().count(9));
//        System.out.println(new Main().count(15));
    }
}
package Examination.Tencent.exam0823.problem03;
/*
给一个数n，把它拆成a+b=n，要求a和b的数位和最大，求这个数位和。
 */
public class Main {
    public int helper(int x) {
        int res = 0;
        int t = x;
        int n = 0;
        while (t != 0) {
            t /= 10;
            n++;
        }
        res = (n - 1) * 9;
        int l = x - (int)(Math.pow(10, n - 1) - 1);
        while (l != 0) {
            res += l % 10;
            l /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 100;
        System.out.println(new Main().helper(x));
    }
}

package Examination.CMB;

import java.util.Scanner;

/*
3
21 1
12345 1
123456 56
 */
public class Solution2 {

    public static int allSolution(String str, int i, int j, long k) {
        long res = 0;
        for (int m = i; m <= j; m++) {
            res = res * 10 + (str.charAt(m) - '0');
        }
        if (i == 0) {
            if (res == k)
                return 1;
            else
                return 0;
        }
        return allSolution(str, i - 1, i - 1, k - res) + allSolution(str, i - 1, i - 1, k + res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String[] str = new String[len];
        int[] k = new int[len];
        scanner.nextLine();
        for (int i = 0; i < len; i++) {
            str[i] = scanner.next();
            k[i] = scanner.nextInt();
        }
        for (int i = 0; i < len; i++) {
            System.out.println(allSolution(str[i], str[i].length() - 1, str[i].length() - 1, k[i]));
        }
    }
}

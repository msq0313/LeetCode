package Examination.JD.exam0917.q1;
/*
And millionaires will hold 46% of total wealth by 2019-3000, the report says. This ratio is likely to increase in 2020.
And millionaires will hold 46% of total wealth by a2019, the report says. This ratio is likely to increase in 2020.
,2999-2000-2003,
,3000-3100-3103,
in 1999,
a2010a,0324abc2020
 */
/*
第一个ac思路:先遍历string，把不是0－9的全换成空格，再用split以空格为依据拆分，最后对每个项判断在不在年份里
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.charAt(i) >= '1' && s.charAt(i) <= '3') {
                String temp = s.substring(i, i + 4);
                boolean flag = true;
                if (i + 4 < s.length()) {
                    if (s.charAt(i + 4) >= '0' && s.charAt(i + 4) <= '9') {
                        continue;
                    }
                }
                if (i - 1 >= 0) {
                    if (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                        continue;
                    }
                }
                for (int j = i; j < i + 4; j++) {
                    if (s.charAt(j) < '0' || s.charAt(j) > '9') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (Integer.parseInt(temp) >= 1000 && Integer.parseInt(temp) <= 3999) {
                        System.out.print(temp + " ");
                    }
                }
            }
        }
    }
}
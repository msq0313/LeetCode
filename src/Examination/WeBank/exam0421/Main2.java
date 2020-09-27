package Examination.WeBank.exam0421;

import java.util.Scanner;

public class Main2 {
    /**
     * 微众 第 2 题，先手博弈问题
     *Cassidy和Eleanore是一对好朋友，她们经常会一起玩游戏。某一天她们玩了一个回文游戏
     * 给出一个仅包含小写字母的字符串S，在每一个人的回合中，她们会进行两个操作：
     * 1、尝试重新排列这个字符串，如果可以把这个字符串排列成回文字符串，则立即获胜
     * 2、否则，她们必须删掉字符串中的一个字符
     * Cassidy先手
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            System.out.println(whoWin(str));
        }
        sc.close();
    }
    private static String whoWin(String str) {
        String p1 = "Cassidy", p2 = "Eleanore"; // p1先手
        // 判断奇数次字符的个数
        // 若该个数为 奇数次，则无论如何都是 Cassidy 赢；
        // 若该个数为 偶数次，则无论如何都是 Eleanore 赢
    /*
我是先猜出结论，再逻辑推导出来的，可以用纸模拟演算一下，比如先分为这么几种情况：
1、当该个数为 奇数次时：
1.1、Cassidy 先手取出一个出现了偶数次的字符，Eleanore后手取出一个出现了偶数次的字符，此时奇数次的字符 += 2（还是奇数）；
1.2、Cassidy 先手取出一个出现了奇数次的字符，Eleanore后手取出一个出现了奇数次的字符，此时奇数次的字符 -= 2；
1.3、Cassidy 先手取出一个出现了奇数次的字符，Eleanore后手取出一个出现了偶数次的字符，此时奇数次的字符不变；
1.4、Cassidy 先手取出一个出现了偶数次的字符，Eleanore后手取出一个出现了奇数次的字符，此时奇数次的字符不变；
上述四种操作进行后，都还是回到原来的起跑线上。
2、当该个数为 偶数次时：同上。
总结下来就是：若该个数为 奇数或偶数次时，Cassidy 和Eleanore分别出手后，平均还是会回到之前的状态（奇 - 2 = 奇，偶 - 2 = 偶）
    */
        return ((oddCharNum(str) & 1) != 0) ? p1 : p2;
    }

    // 判断一个字符串的出现奇数次字符的个数
    private static int oddCharNum(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) arr[str.charAt(i) - 'a'] += 1;

        int oddNum = 0; // 奇数次字符的个数
        for (int num : arr) {
            if ((num & 1) != 0) oddNum++; // 该字符出现了奇次
        }
        return oddNum;
    }

    //  该方法没有被使用
// 判断一个字符串串能否被重排成回文串
    private  static boolean canPalindromic(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) arr[str.charAt(i) - 'a'] += 1;

        int count = 0;
        // 若有两个以上字符出现了奇次，则一定不是回文串，否则是回文串
        for (int num : arr) {
            if ((num & 1) != 0) { // 出现奇次的字符
                count++;
                if (count >= 2) return false;
            }
        }
        return true;
    }
}

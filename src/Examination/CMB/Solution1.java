package Examination.CMB;

import java.util.HashMap;
import java.util.Scanner;

/*
3
69
6996
1111
 */
public class Solution1 {

    public static void main(String[] args) {
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put('1', '1');
        hashMap.put('2', '5');
        hashMap.put('3', '8');
        hashMap.put('4', '7');
        hashMap.put('5', '2');
        hashMap.put('6', '9');
        hashMap.put('7', '4');
        hashMap.put('8', '3');
        hashMap.put('9', '6');
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String[] str = new String[len];
        scanner.nextLine();
        for (int i = 0; i < len; i++) {
            str[i] = scanner.nextLine();
        }
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            StringBuilder stringBuilder = new StringBuilder(str[i]);
            String rev = stringBuilder.reverse() + "";
            for (int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) != hashMap.get(rev.charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
            } else System.out.println("YES");
        }
    }
}

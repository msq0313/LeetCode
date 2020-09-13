package Examination.Sina.q2;
/*
a1b3ba
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean ans = true;
        String s = input.nextLine();
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        char[] res = sort(chars);
        for (int i = 1; i < res.length; i++) {
            if (res[i] == res[i - 1]) {
                ans = false;
                break;
            }
        }
        System.out.println(ans);
    }

    public static char[] sort(char[] chars) {
        quickSort(chars, 0, chars.length - 1);
        return chars;
    }

    public  static void quickSort(char[] chars, int left, int right) {
        if (chars == null || left < 0) {
            return;
        }
        if (left < right) {
            int index = partition(chars, left, right);
            quickSort(chars, left, index - 1);
            quickSort(chars, index + 1, right);
        }
    }

    private static int partition(char[] chars, int left, int right) {
        char pivot = chars[left];
        while (left < right) {
            while (left < right && chars[right] >= pivot)
                right--;
            if (left < right) {
                chars[left++] = chars[right];
            }
            while (left < right && chars[left] <= pivot)
                left++;
            if (left < right) {
                chars[right++] = chars[left];
            }
        }
        chars[left] = pivot;
        return left;
    }
}
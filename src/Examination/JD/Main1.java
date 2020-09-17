package Examination.JD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
1、求由数字 2,3,5 组成的第 n 小的数。（n<=1000）
如，从小到大有，2,3,5,22,23,25，......。第 4 小的数是 22
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String temp = null;
        Queue<String> queue = new LinkedList<>();
        queue.add("2");
        queue.add("3");
        queue.add("5");
        while (n > 0 ) {
            temp = queue.poll();
            queue.offer(temp + "2");
            queue.offer(temp + "3");
            queue.offer(temp + "5");
            n--;
        }
        System.out.println(temp);
    }
}

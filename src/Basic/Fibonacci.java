package Basic;

import java.util.Arrays;
import java.util.Scanner;

//斐波那契数列
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fibonacci fibonacci = new Fibonacci();
        int num = scanner.nextInt();
        System.out.println(Arrays.toString(fibonacci.generate(num)));
        System.out.println(fibonacci.recurrence(num));
    }

    private int[] generate(int num) {
        int[] result = new int[num];
        int a = 1,b = 2;
        for (int i = 0; i < num; i++) {
            result[i] = a;
            int temp = b;
            b = a + b;
            a = temp;
        }
        return result;
    }

    private int recurrence(int num) {
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        return recurrence(num - 1) + recurrence(num - 2);
    }
}

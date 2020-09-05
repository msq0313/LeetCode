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
//        System.out.println(fibonacci.recurrence(num));
//        System.out.println(Arrays.toString(fibonacci.dp(num)));
    }
    //时间复杂度n，空间复杂度1（计算固定数的情况）
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
    //时间复杂度n
    private int[] dp(int num) {
        int[] result = new int[num];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < num; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
    //时间复杂度极高2^n
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

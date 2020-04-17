package Basic;

import java.util.Scanner;

//1加到n
public class n_1 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println((1 + n) * n / 2);
    }
}

package Basic;

import java.math.BigInteger;
import java.util.Scanner;

//大数乘法
public class BigNum {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        while (inputScanner.hasNext()) {
            int n = inputScanner.nextInt();
            BigInteger m;
            m = BigInteger.valueOf(1);//将m定义成大数的1
            for (int i = 1; i <= n; i++) {
                m = m.multiply(BigInteger.valueOf(i));//大数乘法
            }
            System.out.println(m);
        }
    }
}

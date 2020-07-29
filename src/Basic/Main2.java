package Basic;

import java.util.Arrays;
import java.util.Scanner;
/*
 1 2 3 4
 4
 2 1 3 4
 4
 4 3 2 1
 1 2 3 4
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] sortArray = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            sortArray[i] = array[i];
        }
        Arrays.sort(sortArray);
        int c = 0;
        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if(array[i] == sortArray[j]){
                ++c;
                --j;
            }
        }
        System.out.println(n-c);
    }
}
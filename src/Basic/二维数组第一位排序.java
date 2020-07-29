package Basic;

import java.util.Arrays;
import java.util.Comparator;

public class 二维数组第一位排序 {
    public static void main(String[] args) {
        int[][] position = new int[][]{
                {3, 1}, {2, 1}, {1, 1}
        };
        Arrays.sort(position, Comparator.comparingInt(p -> p[0]));
        System.out.println(Arrays.deepToString(position));
    }
}

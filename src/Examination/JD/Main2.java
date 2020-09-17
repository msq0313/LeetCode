package Examination.JD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static List<List<Integer>> list;
    static int n;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= 2 * i - 1; j++) {
                temp.add(sc.nextInt());
            }
            list.add(temp);
        }
        dfs(list.get(0).get(0), 0, 0);
        System.out.println(max);
    }

    static void dfs(int grade, int i, int heigh) {
        if (heigh == n - 1) {
            max = Math.max(grade, max);
            return;
        }

        dfs(grade + list.get(heigh + 1).get(i), i, heigh + 1);
        dfs(grade + list.get(heigh + 1).get(i + 1), i + 1, heigh + 1);
        dfs(grade + list.get(heigh + 1).get(i + 2), i + 2, heigh + 1);
    }
}

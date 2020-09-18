package Examination.JD.exam0917.q2;
/*
2
2 2
.E
S.
2 2
#E
S#
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int group = input.nextInt();
        for (int i = 0; i < group; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            input.nextLine();
            int x = 0;
            int y = 0;
            char[][] chars = new char[n][m];
            boolean[][] isVisited = new boolean[n][m];
            for (int i1 = 0; i1 < n; i1++) {
                String line = input.nextLine();
                for (int i2 = 0; i2 < m; i2++) {
                    chars[i1][i2] = line.charAt(i2);
                    if (chars[i1][i2] == 'S') {
                        x = i1;
                        y = i2;
                    }
                }
            }
            if (dfs(chars, isVisited, x, y)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean dfs(char[][] chars, boolean[][] isVisited, int x, int y) {
        int n = chars.length;
        int m = chars[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (chars[x][y] == 'E') {
            return true;
        }
        if (isVisited[x][y] || chars[x][y] == '#') {
            return false;
        }
        isVisited[x][y] = true;
        return
                dfs(chars, isVisited, x - 1, y) ||
                dfs(chars, isVisited, x + 1, y) ||
                dfs(chars, isVisited, x, y - 1) ||
                dfs(chars, isVisited, x, y + 1);
    }
}
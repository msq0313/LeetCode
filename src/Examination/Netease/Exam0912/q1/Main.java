package Examination.Netease.Exam0912.q1;
/*
3
man woman
coder gamer painter
phd

1
phd
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> res = new ArrayList<>();
    public static List<String> helper(List<List<String>> list) {
        int n = list.size();
        List<String> track = new ArrayList<>();
        dfs(list, n, track);
        return res;
    }

    public static void dfs(List<List<String>> list, int n, List<String> track) {
        if (track.size() == n) {
            StringBuilder sb = new StringBuilder();
            sb.append(track.get(0));
            for (int i = 1; i < track.size(); i++) {
                sb.append('-');
                sb.append(track.get(i));
            }
//            System.out.println(sb.toString());
            res.add(sb.toString());
            return;
        }
        List<String> temp = list.get(track.size());
        for (String s : temp) {
            track.add(s);
            dfs(list, n, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<List<String>> list = new ArrayList<>();
        input.nextLine();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String[] s = line.split(" ");
            List<String> one = new ArrayList<>();
            for (String s1 : s) {
                one.add(s1);
            }
            list.add(one);
        }
        List<String> res = helper(list);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
